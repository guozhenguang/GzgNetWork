package com.konka.gzgnetwork.network.converter

import com.konka.annotation.interfaces.SerializationConverter
import com.konka.gzgnetwork.network.data.IResponseData
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.serializer
import okhttp3.ResponseBody
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import kotlin.reflect.KClass
/**
 * 在code返回SUCEESSD的时候, 我们在Retrofit的Api接口里面只想拿到 data 的数据做返回,我们想在Converter里面处理掉
 * code返回错误码的逻辑,就可以继承BaseResponseBodyConverter,内部已经实现了将response转化为data的逻辑
 */
open abstract class BaseResponseBodyConverter :
    SerializationConverter<ResponseBody, Any> {
    companion object {
        private const val LIST_EMPTY = "[]"
        private const val MAP_EMPTY = "{}"
        private const val STRING_EMPTY = "\"\""
        private const val NUMBER_ZERO = "0"
    }

    lateinit var type: Type

    abstract fun getResultClass(): KClass<out IResponseData<JsonElement>>

    override fun convert(value: ResponseBody): Any? {
        val valueString = value.string()
        val kSerializer: KSerializer<Any> =
                serializer(getResultClass().java)
        val result: IResponseData<JsonElement> =
                json.decodeFromString(kSerializer, valueString) as IResponseData<JsonElement>
        when (result.getErrorCode()) {
            result.isSuccess() -> {
                val data = result.data()
                return if (data == null) {
                    json.decodeFromString(serializer(type), checkType(type))
                } else {
                    json.decodeFromString(serializer(type), json.encodeToString(data))
                }
            }
            else -> throw handlerErrorCode(result.getErrorCode(), result.getErrorMessage())
        }
    }

    abstract fun handlerErrorCode(errorCode: String, msg: String): Exception

    private fun checkType(type: Type): String {
        return when (type) {
            is ParameterizedType -> {
                when (type.rawType) {
                    List::class.java -> {
                        LIST_EMPTY
                    }
                    else -> {
                        MAP_EMPTY
                    }
                }
            }
            String::class.java -> {
                STRING_EMPTY
            }
            Int::class.java,
            Double::class.java,
            Float::class.java,
            Long::class.java -> {
                NUMBER_ZERO
            }
            else -> {
                MAP_EMPTY
            }
        }
    }
}

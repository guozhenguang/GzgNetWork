package com.konka.gzgnetwork.network.converter

import com.konka.gzgnetwork.network.data.IResponseData
import com.konka.gzgnetwork.network.exception.HttpServerException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlin.reflect.KClass
import com.konka.gzgnetwork.network.result.Result


/**
 * 在code返回SUCEESSD的时候, 我们在Retrofit的Api接口里面只想拿到 data 的数据做返回,我们想在Converter里面处理掉
 * code返回错误码的逻辑,就可以继承BaseResponseBodyConverter,内部已经实现了将response转化为data的逻辑
 */
class ResponseBodyConverter :
        BaseResponseBodyConverter() {
    override var json: Json = Json {
        ignoreUnknownKeys = true
    }

    override fun getResultClass(): KClass<out IResponseData<JsonElement>> {
        return Result::class
    }

    override fun handlerErrorCode(errorCode: String, msg: String): Exception {
        return HttpServerException(errorCode,msg)
    }
}
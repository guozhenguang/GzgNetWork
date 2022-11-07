package com.konka.gzgnetwork.network.converter

import com.konka.annotation.interfaces.SerializationConverter
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import okhttp3.ResponseBody
import java.lang.reflect.Type

/**
 * 直接拿response的结果作为网络请求的返回值
 */
class SerializationResponseBodyConverter : SerializationConverter<ResponseBody, Any> {
    lateinit var type: Type
    override var json: Json = Json {
        ignoreUnknownKeys = true
    }

    override fun convert(value: ResponseBody): Any? {
        return json.decodeFromString(serializer(type), value.string())
    }
}
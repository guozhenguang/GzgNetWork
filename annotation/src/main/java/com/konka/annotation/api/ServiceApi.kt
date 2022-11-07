package com.konka.annotation.api

import com.konka.annotation.interfaces.SerializationConverter
import okhttp3.Interceptor
import kotlin.reflect.KClass


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ServiceApi(
    /**
     * 域名或者IP
     */
    val baseUrl: String,
    /**
     * 接收数据转换器(封装的有基类{@see BaseResponseBodyConverter}
     * 也可以不使用基类,直接继承{@see SerializationConverter}
     */
    val responseConverter: KClass<out SerializationConverter<*, *>>,
    /**
     * 连接超时时间(毫秒)
     */
    val connectTimeout: Long = 5000,
    /**
     * 读取超时时间(毫秒)
     */
    val readTimeout: Long = 5000,
    /**
     * 拦截器
     */
    val interceptors: Array<KClass<out Interceptor>> = [],
    /**
     * debug模式的拦截器
     */
    val debugInterceptors: Array<KClass<out Interceptor>> = [],
    /**
     * 是否使用RxJava做转换器
     */
    val rxJava: Boolean = false
)


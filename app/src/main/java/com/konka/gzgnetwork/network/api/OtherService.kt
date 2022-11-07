package com.konka.gzgnetwork.network.api


import com.konka.annotation.api.ServiceApi
import com.konka.gzgnetwork.network.converter.ResponseBodyConverter
import com.konka.gzgnetwork.network.converter.SerializationResponseBodyConverter
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import retrofit2.http.GET
import com.konka.gzgnetwork.network.result.Result

@ServiceApi(
    baseUrl = "https://www.wanandroid.com/",
    responseConverter = SerializationResponseBodyConverter::class,
    debugInterceptors = [OkHttpProfilerInterceptor::class]
)
interface OtherService {
    @GET("banner/json")
    suspend fun queryBanner(): Result
}
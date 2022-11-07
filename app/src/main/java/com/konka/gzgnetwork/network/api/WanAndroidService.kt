package com.konka.gzgnetwork.network.api

import com.konka.annotation.api.ServiceApi
import com.konka.gzgnetwork.network.converter.ResponseBodyConverter
import com.konka.gzgnetwork.network.entity.Article
import com.konka.gzgnetwork.network.entity.Banner
import com.konka.gzgnetwork.network.entity.PageData
import com.konka.gzgnetwork.network.interceptor.RequestInterceptor
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import retrofit2.http.*

@ServiceApi(
        baseUrl = "https://www.wanandroid.com/",
        responseConverter = ResponseBodyConverter::class,
        interceptors = [RequestInterceptor::class],
        debugInterceptors = [OkHttpProfilerInterceptor::class]
)
interface WanAndroidService {

    @POST("user/register")
    suspend fun register(@Body map: Map<String, String>): String

    @GET("banner/json")
    suspend fun queryBanner(): MutableList<Banner>

    @GET("article/list/{pageIndex}/json")
    suspend fun queryArticles(
            @Path("pageIndex") pageIndex: Int,
            @Query("page_size") pageSize: Int
    ): PageData<Article>
}
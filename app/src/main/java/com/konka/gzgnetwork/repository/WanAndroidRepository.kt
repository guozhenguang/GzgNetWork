package com.konka.gzgnetwork.repository

import com.konka.gzgnetwork.network.entity.Article
import com.konka.gzgnetwork.network.manager.NetManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.konka.gzgnetwork.network.api.WanAndroidService
import kotlinx.coroutines.flow.map

/**
 * @author guozhenguang
 * @date 2022/11/7
 * @description
 */
object WanAndroidRepository {
    private val wanAndroidService = NetManager.getInstance().getService(WanAndroidService::class.java)


    fun queryArticles(pageIndex: Int): Flow<MutableList<Article>> {
        val pageSize = 1
        return flow {
            emit(wanAndroidService.queryArticles(pageIndex, pageSize))
        }.map {
            return@map it.datas
        }
    }

}
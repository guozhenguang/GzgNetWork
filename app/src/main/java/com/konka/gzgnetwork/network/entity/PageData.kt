package com.konka.gzgnetwork.network.entity

import kotlinx.serialization.Serializable

@Serializable
data class PageData<T>(val curPage: Int, val datas: MutableList<T>)

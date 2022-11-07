package com.konka.gzgnetwork.network.entity

import kotlinx.serialization.Serializable

@Serializable
data class Article(val title: String, val shareDate: Long)

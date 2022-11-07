package com.konka.gzgnetwork.network.entity

import kotlinx.serialization.Serializable

@Serializable
data class Banner(val desc: String, val imagePath: String, val title: String)

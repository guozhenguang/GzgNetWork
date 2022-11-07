package com.konka.annotation.interfaces

import retrofit2.Converter
import kotlinx.serialization.json.Json

interface SerializationConverter<F, T> : Converter<F, T> {
    var json: Json
}
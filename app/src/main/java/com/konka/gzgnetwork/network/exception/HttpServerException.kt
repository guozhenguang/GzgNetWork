package com.konka.gzgnetwork.network.exception

class HttpServerException(val code: String, message: String) : Exception(message) {
}
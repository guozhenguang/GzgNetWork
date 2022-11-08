package com.konka.gzgnetwork.network.exception

import com.konka.gzgnetwork.ext.logd

class HttpServerException(val code: String, message: String) : Exception(message) {
    init {
        val TAG = "HttpServerException"
        "HttpServerException code: $code, message:$message".logd(TAG)
    }
}
package com.konka.gzgnetwork.compiler

import com.konka.gzgnetwork.network.entity.ServiceParam
import okhttp3.ResponseBody
import retrofit2.Converter
import java.lang.reflect.Type


object KotlinGzgCompiler {
    private const val TAG = "KotlinMvvmCompiler"


    private val serviceApiCompiler: ServiceApiCompiler by lazy {
        var compilerClass =
            Class.forName("${ServiceApiCompiler::class.java.`package`.name}.ServiceApi_Compiler")
        compilerClass.newInstance() as ServiceApiCompiler
    }


    fun getServiceParam(className: String): ServiceParam {
        return serviceApiCompiler.getServiceParam(className)
    }

    fun getResponseBodyConverter(
        className: String,
        type: Type
    ): Converter<ResponseBody, Any>? {
        return serviceApiCompiler.getResponseBodyConverter(className, type)
    }
}
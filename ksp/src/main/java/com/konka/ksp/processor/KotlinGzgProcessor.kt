package com.konka.ksp.processor


import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.konka.ksp.generator.ServiceApiGenerator

class KotlinGzgProcessor(codeGenerator: CodeGenerator, private val logger: KSPLogger) : SymbolProcessor {
    companion object {
        private const val TAG = "KotlinMvvmProcessor"

    }

    private val serviceApiGenerator = ServiceApiGenerator(codeGenerator, logger)

    override fun process(resolver: Resolver): List<KSAnnotated> {
        serviceApiGenerator.process(resolver)
        return emptyList()
    }
}
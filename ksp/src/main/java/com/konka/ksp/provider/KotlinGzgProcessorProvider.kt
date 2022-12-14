package com.konka.ksp.provider

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.konka.ksp.processor.KotlinGzgProcessor

class KotlinGzgProcessorProvider : SymbolProcessorProvider {

    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return KotlinGzgProcessor(environment.codeGenerator, environment.logger)
    }
}
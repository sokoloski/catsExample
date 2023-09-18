package com.willian.cats.presentation.di

import com.example.network.*
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectNetWorkKoinModule() = loadKoinModule

private val loadKoinModule by lazy {
    loadKoinModules(
        module {
            factory<OkHttpClientFactory> {
                CatsApiOkHttpClientFactory()
            }
            single { ApiServiceFactory(get(), get()) }

            single<ApiUrl> {
                CatsApiUrl()
            }
        }
    )
}

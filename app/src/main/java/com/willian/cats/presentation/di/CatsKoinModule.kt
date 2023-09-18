package com.willian.cats.presentation.di

import com.example.network.ApiServiceFactory
import com.willian.cats.data.repository.CatsRepositoryImpl
import com.willian.cats.data.service.CatsService
import com.willian.cats.domain.repository.CatsRepository
import com.willian.cats.presentation.CatsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectCatsKoinModule() {
    lazyLoadKoinModule
}

private val lazyLoadKoinModule by lazy {
    loadKoinModules(
        listOf(
            repositoryModule,
            viewModelModule,
            serviceModule
        )
    )
}

private val repositoryModule = module {
    single<CatsRepository> { CatsRepositoryImpl(get()) }
}

private val viewModelModule = module {
    viewModel { CatsViewModel(get()) }
}

private val serviceModule = module {
    single { get<ApiServiceFactory>().create(CatsService::class.java) }
}

package com.example.cryptoapp.di

import com.example.cryptoapp.data.remote.CoinGeckoApi
import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.model.repository.CoinRepository
import com.example.cryptoapp.presentation.coins.CoinsViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() = startKoin {
    modules(appModule())
}

fun appModule() = module {
    // API
    single { CoinGeckoApi() }

    // Repository
    single<CoinRepository> { CoinRepositoryImpl(get()) }

    // ViewModel
    factory { CoinsViewModel(get()) }
}

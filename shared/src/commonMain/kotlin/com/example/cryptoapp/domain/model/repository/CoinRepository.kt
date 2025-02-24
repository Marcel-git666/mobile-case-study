package com.example.cryptoapp.domain.model.repository

import com.example.cryptoapp.domain.model.Coin

interface CoinRepository {
    suspend fun getTrendingCoins(): List<Coin>
    suspend fun getCoinsList(): List<Coin>
    suspend fun searchCoins(query: String): List<Coin>
    suspend fun getFavoriteCoins(): List<Coin>
    suspend fun toggleFavorite(coinId: String)
}
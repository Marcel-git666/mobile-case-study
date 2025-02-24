package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.remote.CoinGeckoApi
import com.example.cryptoapp.data.remote.models.toCoin
import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.model.repository.CoinRepository

class CoinRepositoryImpl(
    private val api: CoinGeckoApi
) : CoinRepository {
    private val favoriteCoins = mutableSetOf<String>()

    override suspend fun getTrendingCoins(): List<Coin> {
        return api.getTrendingCoins().map { it.toCoin() }
    }

    override suspend fun getCoinsList(): List<Coin> {
        return api.getCoinsList().map { it.toCoin().copy(
            isFavorite = favoriteCoins.contains(it.id)
        ) }
    }

    override suspend fun searchCoins(query: String): List<Coin> {
        return api.searchCoins(query).map { it.toCoin() }
    }

    override suspend fun getFavoriteCoins(): List<Coin> {
        return getCoinsList().filter { coin ->
            favoriteCoins.contains(coin.id)
        }
    }

    override suspend fun toggleFavorite(coinId: String) {
        if (favoriteCoins.contains(coinId)) {
            favoriteCoins.remove(coinId)
        } else {
            favoriteCoins.add(coinId)
        }
    }
}
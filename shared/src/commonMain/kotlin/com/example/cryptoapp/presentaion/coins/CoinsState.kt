package com.example.cryptoapp.presentaion.coins

import com.example.cryptoapp.domain.model.Coin

sealed class CoinsState {
    data object Loading : CoinsState()
    data class Success(
        val trendingCoins: List<Coin>,
        val favoriteCoins: List<Coin>
    ) : CoinsState()
    data class Error(val message: String) : CoinsState()
}
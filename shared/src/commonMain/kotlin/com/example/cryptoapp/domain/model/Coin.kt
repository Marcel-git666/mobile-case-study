package com.example.cryptoapp.domain.model

@kotlinx.serialization.Serializable
data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Double,
    val priceChangePercentage24h: Double,
    val isFavorite: Boolean = false
)
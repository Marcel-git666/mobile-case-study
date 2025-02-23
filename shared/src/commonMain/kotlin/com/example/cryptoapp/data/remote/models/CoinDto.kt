package com.example.cryptoapp.data.remote.models

import com.example.cryptoapp.domain.model.Coin

@kotlinx.serialization.Serializable
data class CoinDto(
    val id: String,
    @kotlinx.serialization.SerialName("symbol")
    val symbol: String,
    @kotlinx.serialization.SerialName("name")
    val name: String,
    @kotlinx.serialization.SerialName("image")
    val image: String,
    @kotlinx.serialization.SerialName("current_price")
    val currentPrice: Double,
    @kotlinx.serialization.SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double
)

fun CoinDto.toCoin() = Coin(
    id = id,
    symbol = symbol,
    name = name,
    image = image,
    currentPrice = currentPrice,
    priceChangePercentage24h = priceChangePercentage24h,
    isFavorite = false // výchozí hodnota pro nově načtené coiny
)
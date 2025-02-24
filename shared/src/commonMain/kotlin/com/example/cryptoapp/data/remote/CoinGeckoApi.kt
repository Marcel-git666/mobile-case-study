package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.models.CoinDto
import com.example.cryptoapp.util.Constants
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class CoinGeckoApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getTrendingCoins(): List<CoinDto> {
        return client.get("${Constants.COINGECKO_BASE_URL}${Constants.TRENDING_ENDPOINT}")
            .body()
    }

    suspend fun getCoinsList(): List<CoinDto> {
        return client.get("${Constants.COINGECKO_BASE_URL}${Constants.COINS_LIST_ENDPOINT}")
            .body()
    }

    suspend fun searchCoins(query: String): List<CoinDto> {
        return client.get("${Constants.COINGECKO_BASE_URL}${Constants.SEARCH_ENDPOINT}") {
            url {
                parameters.append("query", query)
            }
        }.body()
    }
}
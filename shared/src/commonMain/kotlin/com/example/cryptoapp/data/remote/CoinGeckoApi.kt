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

    suspend fun getCoinsList(
        vsCurrency: String = "usd",
        order: String = "market_cap_desc",
        perPage: Int = 250,
        page: Int = 1
    ): List<CoinDto> {
        return client.get("${Constants.COINGECKO_BASE_URL}${Constants.COINS_LIST_ENDPOINT}") {
            url {
                parameters.append("vs_currency", vsCurrency)
                parameters.append("order", order)
                parameters.append("per_page", perPage.toString())
                parameters.append("page", page.toString())
            }
        }.body()
    }

    suspend fun searchCoins(query: String): List<CoinDto> {
        return client.get("${Constants.COINGECKO_BASE_URL}${Constants.SEARCH_ENDPOINT}") {
            url {
                parameters.append("query", query)
            }
        }.body()
    }
}
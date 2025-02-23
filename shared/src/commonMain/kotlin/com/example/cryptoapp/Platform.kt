package com.example.cryptoapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
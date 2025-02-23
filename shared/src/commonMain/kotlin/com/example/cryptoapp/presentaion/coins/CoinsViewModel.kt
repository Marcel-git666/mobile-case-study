package com.example.cryptoapp.presentaion.coins

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoinsViewModel(
    private val repository: CoinRepository
) : ViewModel() {
    private val _state = MutableStateFlow<CoinsState>(CoinsState.Loading)
    val state: StateFlow<CoinsState> = _state.asStateFlow()

    init {
        loadCoins()
    }

    private fun loadCoins() {
        viewModelScope.launch {
            try {
                val trending = repository.getTrendingCoins()
                val favorites = repository.getFavoriteCoins()
                _state.value = CoinsState.Success(
                    trendingCoins = trending,
                    favoriteCoins = favorites
                )
            } catch (e: Exception) {
                _state.value = CoinsState.Error(e.message ?: "Unknown error occurred")
            }
        }
    }

    fun toggleFavorite(coinId: String) {
        viewModelScope.launch {
            repository.toggleFavorite(coinId)
            loadCoins() // Reload po změně
        }
    }
}
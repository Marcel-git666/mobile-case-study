package com.example.cryptoapp.presentation.coins

import com.example.cryptoapp.domain.model.repository.CoinRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel

class CoinsViewModel: ViewModel() {
//    private val repository: CoinRepository
    private val _state = MutableStateFlow<CoinsState>(CoinsState.Loading)
    val state: StateFlow<CoinsState> = _state
//    val counter: StateFlow<Int> = _counter

    init {
        loadCoins()
    }

    private fun loadCoins() {
//        _counter.value += 1
        println(message = "Coins are loaded.")
    }
}

//
//    private val repository: CoinRepository
//) {
//    private val viewModelScope = CoroutineScope(Dispatchers.Main)
//
//
//    init {
//        loadCoins()
//    }
//
//    private fun loadCoins() {
//        viewModelScope.launch {
//            try {
//                val trending = repository.getTrendingCoins()
//                val favorites = repository.getFavoriteCoins()
//                _state.value = CoinsState.Success(
//                    trendingCoins = trending,
//                    favoriteCoins = favorites
//                )
//            } catch (e: Exception) {
//                _state.value = CoinsState.Error(e.message ?: "Unknown error occurred")
//            }
//        }
//    }
//
//    fun toggleFavorite(coinId: String) {
//        viewModelScope.launch {
//            repository.toggleFavorite(coinId)
//            loadCoins() // Reload po změně
//        }
//    }
//}
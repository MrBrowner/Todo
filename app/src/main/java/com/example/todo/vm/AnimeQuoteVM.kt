package com.example.todo.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.domain.repo.AnimeQuoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeQuoteVM(
    private val quoteRepo: AnimeQuoteRepo
) : ViewModel() {

    fun generateRandomQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepo.getRandomQuote().onSuccess {

            }.onFailure {

            }
        }
    }
}
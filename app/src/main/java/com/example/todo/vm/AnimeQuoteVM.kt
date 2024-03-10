package com.example.todo.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.todo.domain.model.AnimeQuote
import com.example.todo.domain.repo.AnimeQuoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class AnimeQuoteVM(
    private val quoteRepo: AnimeQuoteRepo
) : ViewModel() {

    val msg = "Hey"
    val q2 = MutableStateFlow<AnimeQuote?>(null)

    fun generateRandomQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepo.getRandomQuote()
                .onSuccess {
                    q2.emit(it)
                }.onFailure {
                    Timber.e(it)
                    q2.emit(null)
                }
        }
    }
}
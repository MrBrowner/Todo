package com.example.todo.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.domain.model.AnimeQuote
import com.example.todo.domain.repo.AnimeQuoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class AnimeQuoteVM(
    private val quoteRepo: AnimeQuoteRepo
) : ViewModel() {

    val msg = "Hey"
    val quote = MutableLiveData<AnimeQuote?>()

    fun generateRandomQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepo.getRandomQuote()
                .onSuccess {
                    quote.postValue(it)
                }.onFailure {
                    Timber.e(it)
                    quote.postValue(null)
                }
        }
    }
}
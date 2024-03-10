package com.example.todo.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.domain.model.AnimeQuote
import com.example.todo.domain.repo.AnimeQuoteRepo
import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class AnimeQuoteVM(
    private val quoteBox: Box<AnimeQuote>,
    private val quoteRepo: AnimeQuoteRepo
) : ViewModel() {

    private var liveQuote: ObjectBoxLiveData<AnimeQuote> = ObjectBoxLiveData(null)

    val q2 = MutableStateFlow<AnimeQuote?>(null)

    init {
        Timber.e("init")
    }

    fun getQuotesLiveData(): ObjectBoxLiveData<AnimeQuote> {
        liveQuote = ObjectBoxLiveData(quoteBox.query().build())
        return liveQuote
    }

    fun generateRandomQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepo.getRandomQuote()
                .onSuccess {
                    quoteBox.put(it)
                    q2.emit(it)
                }.onFailure {
                    Timber.e(it)
                    q2.emit(null)
                }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.e("onCleared")
    }
}
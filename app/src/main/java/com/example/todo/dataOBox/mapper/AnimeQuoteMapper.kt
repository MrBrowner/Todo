package com.example.todo.dataOBox.mapper

import com.example.todo.dataOBox.network.model.AnimeQuoteNetworkModel
import com.example.todo.domain.model.AnimeQuote

fun AnimeQuoteNetworkModel.toQuote(): AnimeQuote {
    return AnimeQuote(
        anime = anime ?: "",
        character = character ?: "",
        quote = quote ?: ""
    )
}
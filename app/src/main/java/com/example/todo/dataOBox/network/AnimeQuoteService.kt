package com.example.todo.dataOBox.network

import com.example.todo.domain.model.AnimeQuote
import retrofit2.http.GET

interface AnimeQuoteService {
    @GET("random")
    suspend fun getRandomQuote(): AnimeQuote
}
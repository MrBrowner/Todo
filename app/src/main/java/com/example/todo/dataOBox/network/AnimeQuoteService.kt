package com.example.todo.dataOBox.network

import com.example.todo.dataOBox.network.model.AnimeQuoteNetworkModel
import retrofit2.http.GET

interface AnimeQuoteService {
    @GET("random")
    suspend fun getRandomQuote(): AnimeQuoteNetworkModel
}
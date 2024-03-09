package com.example.todo.dataOBox.network.model

import retrofit2.http.GET

interface AnimeQuoteService {
    @GET("/random")
    suspend fun getRandomQuote(): AnimeQuoteNetworkModel
}
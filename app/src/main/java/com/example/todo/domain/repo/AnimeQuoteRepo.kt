package com.example.todo.domain.repo

import com.example.todo.domain.model.AnimeQuote

interface AnimeQuoteRepo {
    suspend fun getRandomQuote(): Result<AnimeQuote>
}
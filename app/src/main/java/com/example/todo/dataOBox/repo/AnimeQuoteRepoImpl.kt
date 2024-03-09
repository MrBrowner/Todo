package com.example.todo.dataOBox.repo

import com.example.todo.dataOBox.mapper.toQuote
import com.example.todo.dataOBox.network.AnimeQuoteService
import com.example.todo.domain.model.AnimeQuote
import com.example.todo.domain.repo.AnimeQuoteRepo

class AnimeQuoteRepoImpl(
    private val service: AnimeQuoteService
): AnimeQuoteRepo {
    override suspend fun getRandomQuote(): Result<AnimeQuote> {
        return try {
            Result.success(service.getRandomQuote().toQuote())
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}
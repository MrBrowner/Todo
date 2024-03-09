package com.example.todo.dataOBox

import kotlinx.serialization.Serializable

@Serializable
data class AnimeQuote(
    val anime: String? = null,
    val character: String? = null,
    val quote: String? = null,
)

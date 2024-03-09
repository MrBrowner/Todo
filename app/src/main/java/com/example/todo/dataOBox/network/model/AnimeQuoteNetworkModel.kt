package com.example.todo.dataOBox.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AnimeQuoteNetworkModel(
    val anime: String? = null,
    val character: String? = null,
    val quote: String? = null,
)
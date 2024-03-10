package com.example.todo.domain.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class AnimeQuote(
    @Id
    var id: Long = 0L,
    val anime: String? = null,
    val character: String? = null,
    val quote: String? = null,
)
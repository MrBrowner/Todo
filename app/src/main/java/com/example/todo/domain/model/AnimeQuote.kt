package com.example.todo.domain.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Entity
@Serializable
data class AnimeQuote(
    @Id
    @Transient
    var id: Long = 0L,
    val anime: String? = null,
    val character: String? = null,
    val quote: String? = null,
)
package com.example.notes.model

import kotlin.time.Instant

data class NoteModel(
    val noteId: Int,
    val noteTitle: String?,
    val noteContent: String?,
    val createdAt: Instant,
    val updatedAt: Instant
)
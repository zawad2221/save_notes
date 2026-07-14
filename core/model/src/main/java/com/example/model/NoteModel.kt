package com.example.model

data class NoteModel(
    val noteId: Int,
    val noteTitle: String?,
    val noteContent: String?,
    val createdAt: Long,
    val updatedAt: Long,
    val isPinned: Boolean = false
)
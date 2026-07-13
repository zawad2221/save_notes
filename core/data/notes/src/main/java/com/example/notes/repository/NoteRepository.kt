package com.example.notes.repository

import com.example.database.model.NoteEntity
import com.example.notes.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<NoteModel>>
    suspend fun getNoteById(id: Int): Flow<NoteModel>

    suspend fun searchNotes(query: String): Flow<List<NoteModel>>

    suspend fun deleteNoteById(id: Int)
    suspend fun updateNote(id: Int, title: String, content: String)
    suspend fun insertNote(title: String, content: String)
    val pinnedNoteIds: Flow<Set<Int>>
    suspend fun pinNote(noteId: Int)
    suspend fun unpinNote(noteId: Int)
}
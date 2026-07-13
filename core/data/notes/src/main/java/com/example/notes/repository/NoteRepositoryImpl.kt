package com.example.notes.repository

import com.example.notes.util.TimeUtils
import com.example.database.dao.NoteDao
import com.example.database.model.NoteEntity
import com.example.datastore.PinNoteDataSource
import com.example.notes.mapper.toNoteModel
import com.example.notes.model.NoteModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao,
    private val pinNoteDataSource: PinNoteDataSource
) : NoteRepository {

    override val pinnedNoteIds: Flow<Set<Int>> = pinNoteDataSource.pinnedNoteIds

    override fun getAllNotes(): Flow<List<NoteModel>> {
        return combine(noteDao.getAllNotes(), pinNoteDataSource.pinnedNoteIds) { notes, pinnedIds ->
            notes.map { entity ->
                entity.toNoteModel().copy(isPinned = pinnedIds.contains(entity.id))
            }
        }
    }

    override suspend fun getNoteById(id: Int): Flow<NoteModel> {
        return combine(noteDao.getNoteById(id), pinNoteDataSource.pinnedNoteIds) { note, pinnedIds ->
            note.toNoteModel().copy(isPinned = pinnedIds.contains(note.id))
        }
    }

    override suspend fun deleteNoteById(id: Int) {
        noteDao.deleteNoteById(id)
    }

    override suspend fun updateNote(id: Int, title: String, content: String) {
        noteDao.updateNote(id = id, title = title, content = content, updateAt = TimeUtils.now())
    }

    override suspend fun searchNotes(query: String): Flow<List<NoteModel>> {
        return combine(noteDao.searchNotes(query), pinNoteDataSource.pinnedNoteIds) { notes, pinnedIds ->
            notes.map { entity ->
                entity.toNoteModel().copy(isPinned = pinnedIds.contains(entity.id))
            }
        }
    }

    override suspend fun insertNote(title: String, content: String): Long {
        return noteDao.insertNote(
            NoteEntity(
                title = title,
                content = content,
                createdAt = TimeUtils.now(),
                updatedAt = TimeUtils.now()
            )
        )
    }

    override suspend fun pinNote(noteId: Int) {
        pinNoteDataSource.pinNote(noteId)
    }

    override suspend fun unpinNote(noteId: Int) {
        pinNoteDataSource.unpinNote(noteId)
    }
}
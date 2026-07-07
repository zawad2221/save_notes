package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.model.NoteEntity
import kotlinx.coroutines.flow.Flow
import kotlin.time.Instant

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id: Int): Flow<NoteEntity>

    @Query("DELETE FROM notes WHERE id = :id")
    fun deleteNoteById(id: Int)


    @Query("UPDATE notes SET title = :title, content = :content, updatedAt = :updateAt WHERE id = :id")
    fun updateNote(id: Int, title: String, content: String, updateAt: Instant)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteEntity: NoteEntity)
}
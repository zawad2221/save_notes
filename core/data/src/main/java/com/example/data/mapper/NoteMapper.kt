package com.example.data.mapper

import com.example.database.model.NoteEntity
import com.example.model.NoteModel

fun NoteEntity.toNoteModel(): NoteModel {
    return NoteModel(
        noteId = id,
        noteTitle = title,
        noteContent = content,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun NoteModel.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = noteId,
        title = noteTitle ?: "",
        content = noteContent ?: "",
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun List<NoteEntity>.toNoteModelList(): List<NoteModel> {
    return map { it.toNoteModel() }
}

fun List<NoteModel>.toNoteEntityList(): List<NoteEntity> {
    return map { it.toNoteEntity() }
}
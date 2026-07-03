package com.example.notes.state

import com.example.notes.model.NoteModel

sealed interface NoteEditUiState {
    data class Success(val data: NoteModel) : NoteEditUiState
    data object Error : NoteEditUiState
    data object Loading : NoteEditUiState
    data object Empty : NoteEditUiState
}
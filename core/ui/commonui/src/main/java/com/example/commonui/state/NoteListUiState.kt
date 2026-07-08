package com.example.commonui.state

import com.example.notes.model.NoteModel

sealed interface NoteListUiState {
    data class Success(val data: List<NoteModel>) : NoteListUiState
    data object Error : NoteListUiState
    data object Loading : NoteListUiState
    data object Empty : NoteListUiState
}
package com.example.commonui

import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.items
import com.example.commonui.components.NoteCard
import com.example.commonui.state.NoteListUiState
import com.example.notes.model.NoteModel

fun LazyStaggeredGridScope.noteGridItems(
    noteListUiState: NoteListUiState,
    selectedNotes: Set<Int>,
    isInSelectionMode: Boolean,
    onNoteSelected: (Int) -> Unit,
    onNoteClicked: (Int) -> Unit
) {
    when (noteListUiState) {
        is NoteListUiState.Success -> {
            items(noteListUiState.data) { note ->
                NoteCard(
                    noteId = note.noteId,
                    title = note.noteTitle ?: "",
                    content = note.noteContent ?: "",
                    isSelected = selectedNotes.contains(note.noteId),
                    onSelected = onNoteSelected,
                    onCardClick = { noteId ->
                        if (isInSelectionMode) {
                            onNoteSelected(noteId)
                        } else {
                            onNoteClicked(noteId)
                        }
                    }
                )
            }
        }

        else -> {}
    }
}
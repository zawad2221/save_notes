package com.example.notes.sceens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.design_system.theme.CustomTheme
import com.example.notes.components.NoteCard
import com.example.notes.state.NoteListUiState
import com.example.notes.viewmodel.NotesViewModel

@Composable
fun NotesLandingScreen(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel = hiltViewModel(),
    onNoteClicked: (Int) -> Unit = {},
    onAddNoteClicked: () -> Unit = {}
) {
    val selectedNotes by viewModel.selectedNotes.collectAsStateWithLifecycle()
    val selectionMode by viewModel.isSelectionMode.collectAsStateWithLifecycle()
    val noteListUiState by viewModel.noteListUiState.collectAsStateWithLifecycle()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = CustomTheme.colors.WhiteAlpha100,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNoteClicked,
                containerColor = CustomTheme.colors.PureBlackAlpha100,
                contentColor = CustomTheme.colors.WhiteAlpha100
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(CustomTheme.colors.WhiteAlpha100)
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    horizontal = CustomTheme.spacing.spacing16dp
                ),
                horizontalArrangement = Arrangement.spacedBy(CustomTheme.spacing.spacing8dp),
                verticalItemSpacing = CustomTheme.spacing.spacing8dp
            ) {
                when (noteListUiState) {
                    is NoteListUiState.Success -> {
                        items((noteListUiState as NoteListUiState.Success).data) { note ->
                            NoteCard(
                                noteId = note.noteId,
                                title = note.noteTitle ?: "",
                                content = note.noteContent ?: "",
                                isSelected = selectedNotes.contains(note.noteId),
                                onSelected = { noteId ->
                                    viewModel.selectNote(noteId)
                                },
                                onCardClick = { noteId ->
                                    if (selectionMode) {
                                        viewModel.selectNote(noteId)
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
        }
    }
}

package com.example.notes.sceens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.design_system.theme.CustomTheme
import com.example.notes.components.NoteCard
import com.example.notes.viewmodel.NotesViewModel

@Composable
fun NotesLandingScreen(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel = hiltViewModel(),
    onNoteClicked: (Int) -> Unit = {}
) {
    val selectedNotes by viewModel.selectedNotes.collectAsStateWithLifecycle()
    val selectionMode by viewModel.isSelectionMode.collectAsStateWithLifecycle()
    Box(
        modifier = modifier
            .fillMaxSize()
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
            items(11) {
                //todo: remove test data
                NoteCard(
                    noteId = it,
                    title = "Text",
                    content = if (it % 2 == 0) "Text" else
                        "Tedfdfddfdfdfdfdddjjjjjdjdjdjdjdj jddjdjdjjd djdjdjdj ddjjdjd jdjkkfkkkdfdfd",
                    isSelected = selectedNotes.contains(it),
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
    }
}
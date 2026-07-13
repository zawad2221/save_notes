package com.example.notes.sceens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.commonui.components.SelectionToolbar
import com.example.commonui.noteGridItems
import com.example.design_system.theme.CustomTheme
import com.example.notes.viewmodel.NotesViewModel

@Composable
fun NotesLandingScreen(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel = hiltViewModel(),
    onNoteClicked: (Int) -> Unit = {},
    onAddNoteClicked: () -> Unit = {},
    onSearchClicked: () -> Unit = {}
) {
    val selectedNotes by viewModel.selectedNotes.collectAsStateWithLifecycle()
    val selectionMode by viewModel.isSelectionMode.collectAsStateWithLifecycle()
    val isAllPinned by viewModel.isAllSelectedNotesPinned.collectAsStateWithLifecycle()
    val noteListUiState by viewModel.noteListUiState.collectAsStateWithLifecycle()

    BackHandler(enabled = selectionMode) {
        viewModel.clearSelection()
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = CustomTheme.colors.WhiteAlpha100,
        topBar = {
            if (selectionMode) {
                SelectionToolbar(
                    selectedCount = selectedNotes.size,
                    isAllPinned = isAllPinned,
                    onCloseClicked = { viewModel.clearSelection() },
                    onPinClicked = { viewModel.pinSelectedNotes() },
                    onDeleteClicked = { viewModel.deleteSelectedNotes() }
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = CustomTheme.spacing.spacing16dp,
                            bottom = CustomTheme.spacing.spacing1dp
                        )
                        .padding(horizontal = CustomTheme.spacing.spacing16dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(CustomTheme.spacing.spacing24dp))
                        .background(CustomTheme.colors.PureBlackAlpha5)
                        .clickable { onSearchClicked() }
                        .padding(horizontal = CustomTheme.spacing.spacing16dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(CustomTheme.spacing.spacing8dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = CustomTheme.colors.PureBlackAlpha40
                        )
                        Text(
                            text = "Search notes...",
                            style = CustomTheme.typography.body1,
                            color = CustomTheme.colors.PureBlackAlpha40
                        )
                    }
                }
            }
        },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = CustomTheme.spacing.spacing16dp)
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
                noteGridItems(
                    noteListUiState = noteListUiState,
                    selectedNotes = selectedNotes,
                    isInSelectionMode = selectionMode,
                    onNoteSelected = { noteId ->
                        viewModel.selectNote(noteId)
                    },
                    onNoteClicked = { noteId ->
                        onNoteClicked(noteId)
                    }
                )
            }
        }
    }
}

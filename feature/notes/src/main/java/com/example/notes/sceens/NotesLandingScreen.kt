package com.example.notes.sceens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.commonui.components.SelectionToolbar
import com.example.commonui.components.ThemeSettingsDialog
import com.example.commonui.noteItems
import com.example.commonui.state.NoteListUiState
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
    val showThemeDialog by viewModel.showThemeDialog.collectAsStateWithLifecycle()
    val themeConfig by viewModel.themeConfig.collectAsStateWithLifecycle()

    if (showThemeDialog) {
        ThemeSettingsDialog(
            onDismiss = { viewModel.setShowThemeDialog(false) },
            currentThemeConfig = themeConfig,
            onThemeConfigChange = {
                viewModel.setThemeConfig(it)
                viewModel.setShowThemeDialog(false)
            }
        )
    }

    BackHandler(enabled = selectionMode) {
        viewModel.clearSelection()
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = CustomTheme.colors.BackgroundPrimary,
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
                        .height(CustomTheme.spacing.spacing48dp)
                        .clip(RoundedCornerShape(CustomTheme.spacing.spacing24dp))
                        .background(CustomTheme.colors.BackgroundSecondary),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(CustomTheme.spacing.spacing24dp))
                                .clickable { onSearchClicked() }
                                .padding(start = CustomTheme.spacing.spacing16dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(CustomTheme.spacing.spacing8dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                tint = CustomTheme.colors.FillPrimary40
                            )
                            Text(
                                text = "Search notes...",
                                style = CustomTheme.typography.body1
                            )
                        }

                        IconButton(
                            onClick = { viewModel.setShowThemeDialog(true) },
                            modifier = Modifier.padding(end = CustomTheme.spacing.spacing4dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Settings",
                                tint = CustomTheme.colors.FillPrimary40
                            )
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNoteClicked,
                containerColor = CustomTheme.colors.FillIconPrimary,
                contentColor = CustomTheme.colors.FillPrimary5
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
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = CustomTheme.spacing.spacing16dp,
                    end = CustomTheme.spacing.spacing16dp,
                    bottom = CustomTheme.spacing.spacing16dp
                ),
                horizontalArrangement = Arrangement.spacedBy(CustomTheme.spacing.spacing8dp),
                verticalItemSpacing = CustomTheme.spacing.spacing8dp
            ) {
                val state = noteListUiState
                if (state is NoteListUiState.Success) {
                    val notes = state.data
                    val pinnedNotes = notes.filter { it.isPinned }
                    val otherNotes = notes.filter { !it.isPinned }

                    if (pinnedNotes.isNotEmpty()) {
                        item(span = StaggeredGridItemSpan.FullLine) {
                            Text(
                                text = "Pinned",
                                style = CustomTheme.typography.subhead2,
                                modifier = Modifier.padding(
                                    top = CustomTheme.spacing.spacing8dp,
                                    bottom = CustomTheme.spacing.spacing8dp,
                                    start = CustomTheme.spacing.spacing4dp,
                                    end = CustomTheme.spacing.spacing4dp
                                )
                            )
                        }
                        noteItems(
                            notes = pinnedNotes,
                            selectedNotes = selectedNotes,
                            isInSelectionMode = selectionMode,
                            onNoteSelected = { noteId ->
                                viewModel.selectNote(noteId)
                            },
                            onNoteClicked = { noteId ->
                                onNoteClicked(noteId)
                            }
                        )

                        if (otherNotes.isNotEmpty()) {
                            item(span = StaggeredGridItemSpan.FullLine) {
                                Text(
                                    text = "Others",
                                    style = CustomTheme.typography.subhead2,
                                    modifier = Modifier.padding(
                                        top = CustomTheme.spacing.spacing16dp,
                                        bottom = CustomTheme.spacing.spacing8dp,
                                        start = CustomTheme.spacing.spacing4dp,
                                        end = CustomTheme.spacing.spacing4dp
                                    )
                                )
                            }
                        }
                    }

                    noteItems(
                        notes = otherNotes,
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
}

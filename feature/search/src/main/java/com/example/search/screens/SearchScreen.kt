package com.example.search.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.commonui.components.SelectionToolbar
import com.example.commonui.noteGridItems
import com.example.design_system.theme.CustomTheme
import com.example.search.viewmodel.SearchViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel(),
    onNoteClicked: (Int) -> Unit = {},
    onBackAction: () -> Unit = {},
) {
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
    val searchResult by viewModel.searchResult.collectAsStateWithLifecycle()
    val selectedNotes by viewModel.selectedNotes.collectAsStateWithLifecycle()
    val isAllPinned by viewModel.isAllSelectedNotesPinned.collectAsStateWithLifecycle()
    val selectionMode by viewModel.isSelectionMode.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CustomTheme.colors.WhiteAlpha100)
    ) {
        if (selectionMode) {
            SelectionToolbar(
                selectedCount = selectedNotes.size,
                isAllPinned = isAllPinned,
                onCloseClicked = viewModel::clearSelection,
                onPinClicked = viewModel::pinSelectedNotes,
                onDeleteClicked = viewModel::deleteSelectedNotes
            )
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = CustomTheme.spacing.spacing8dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackAction) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = CustomTheme.colors.PureBlackAlpha100
                    )
                }
                TextField(
                    value = searchQuery,
                    onValueChange = { viewModel.onSearchQueryChanged(it) },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text(text = "Search notes...") },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = {
                                viewModel.onSearchQueryChanged("")
                                viewModel.clearSelection()
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Clear"
                                )
                            }
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    singleLine = true
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = CustomTheme.spacing.spacing16dp),
                thickness = 1.dp,
                color = CustomTheme.colors.PureBlackAlpha10
            )
        }

        Spacer(modifier = Modifier.height(CustomTheme.spacing.spacing16dp))

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = CustomTheme.spacing.spacing16dp,
                end = CustomTheme.spacing.spacing16dp,
                bottom = CustomTheme.spacing.spacing16dp,
            ),
            horizontalArrangement = Arrangement.spacedBy(CustomTheme.spacing.spacing8dp),
            verticalItemSpacing = CustomTheme.spacing.spacing8dp
        ) {
            noteGridItems(
                noteListUiState = searchResult,
                selectedNotes = selectedNotes,
                isInSelectionMode = selectionMode,
                onNoteSelected = viewModel::selectNote,
                onNoteClicked = onNoteClicked
            )
        }
    }
}

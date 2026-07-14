package com.example.notes.sceens

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.design_system.theme.CustomTheme
import com.example.notes.state.NoteEditUiState
import com.example.notes.viewmodel.NoteEditViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NoteAddEditScreen(
    modifier: Modifier = Modifier,
    viewModel: NoteEditViewModel = hiltViewModel(),
    noteId: Int,
    onBackAction: () -> Unit
) {
    LaunchedEffect(key1 = noteId) {
        viewModel.setSelectedNoteId(noteId)
    }
    val selectedNoteUiState by viewModel.selectedNoteUiState.collectAsStateWithLifecycle()
    val isPinned by viewModel.isPinned.collectAsStateWithLifecycle()
    var title by rememberSaveable { mutableStateOf("") }
    var content by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(selectedNoteUiState) {
        when (selectedNoteUiState) {
            is NoteEditUiState.Success -> {
                val note = (selectedNoteUiState as NoteEditUiState.Success).data
                title = note.noteTitle ?: ""
                content = note.noteContent ?: ""
            }

            else -> {}
        }
    }
    DisposableEffect(Unit) {
        onDispose {
            if (title.isNotEmpty() || content.isNotEmpty()) {
                viewModel.saveOrUpdateNote(
                    noteId = noteId,
                    noteTitle = title,
                    noteContent = content
                )
            }
        }
    }

    Scaffold(
        containerColor = CustomTheme.colors.BackgroundPrimary,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = CustomTheme.spacing.spacing12dp,
                        end = CustomTheme.spacing.spacing12dp,
                        top = CustomTheme.spacing.spacing16dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    tint = CustomTheme.colors.BrandPrimary100,
                    modifier = Modifier
                        .size(CustomTheme.spacing.spacing24dp)
                        .clip(CircleShape)
                        .clickable(onClick = onBackAction),
                    contentDescription = "Back"
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { viewModel.togglePin() }) {
                    Icon(
                        imageVector = if (isPinned) Icons.Default.PushPin else Icons.Outlined.PushPin,
                        tint = CustomTheme.colors.BrandPrimary100,
                        modifier = Modifier.size(CustomTheme.spacing.spacing24dp),
                        contentDescription = "Pin"
                    )
                }
            }
        },
        modifier = modifier
            .fillMaxSize()
    ) { paddingValues ->
        NoteEditFields(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = CustomTheme.spacing.spacing16dp)
                .padding(top = CustomTheme.spacing.spacing32dp),
            initialTitle = title, initialContent = content,
            onTitleChange = {
                title = it
            },
            onContentChange = {
                content = it
            })
    }
}

@Composable
fun NoteEditFields(
    modifier: Modifier,
    initialTitle: String = "",
    initialContent: String = "",
    onTitleChange: (String) -> Unit = {},
    onContentChange: (String) -> Unit = {}
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = initialTitle,
                textStyle = CustomTheme.typography.titleHeader,
                onValueChange = {
                    onTitleChange(it)
                }, cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface),

                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.fillMaxWidth()) {
                        if (initialTitle.isEmpty()) {
                            Text(
                                text = "Title",
                                style = CustomTheme.typography.titleHeader.copy(color = CustomTheme.colors.TextSecondary)
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
        item {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = CustomTheme.spacing.spacing16dp),
                value = initialContent,
                textStyle = CustomTheme.typography.body1,
                onValueChange = {
                    onContentChange(it)
                }, cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface),

                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.fillMaxWidth()) {
                        if (initialContent.isEmpty()) {
                            Text(
                                text = "Note",
                                style = CustomTheme.typography.body1.copy(color = CustomTheme.colors.TextSecondary)
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}
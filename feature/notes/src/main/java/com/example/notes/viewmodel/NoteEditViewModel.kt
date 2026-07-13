package com.example.notes.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.di.ApplicationScope
import com.example.constants.NoteConstants
import com.example.notes.repository.NoteRepository
import com.example.notes.state.NoteEditUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val noteRepository: NoteRepository,
    @ApplicationScope private val applicationScope: CoroutineScope
) : ViewModel() {

    private val noteToEditId =
        savedStateHandle.getStateFlow(key = NoteConstants.NOTE_ID, initialValue = -1)

    @OptIn(ExperimentalCoroutinesApi::class)
    val isPinned: StateFlow<Boolean> = noteToEditId.flatMapLatest { noteId ->
        if (noteId == -1) flowOf(false)
        else noteRepository.pinnedNoteIds.map { it.contains(noteId) }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = false
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    val selectedNoteUiState: StateFlow<NoteEditUiState> = noteToEditId.flatMapLatest { noteId ->
        if (noteId == -1) {
            flowOf(NoteEditUiState.Empty)
        } else {
            getNote(noteId).flatMapLatest {
                flowOf(NoteEditUiState.Success(it))
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = NoteEditUiState.Loading
    )

    fun setSelectedNoteId(noteId: Int) {
        savedStateHandle[NoteConstants.NOTE_ID] = noteId
    }

    fun saveOrUpdateNote(noteId: Int?, noteTitle: String, noteContent: String) {
        applicationScope.launch {
            noteId?.takeIf { it >= 0 }?.let {
                noteRepository.updateNote(noteId, noteTitle, noteContent)
            } ?: run {
                noteRepository.insertNote(title = noteTitle, content = noteContent)
            }
        }
    }

    suspend fun getNote(noteId: Int) = noteRepository.getNoteById(noteId)

    fun togglePin() {
        val noteId = noteToEditId.value
        if (noteId == -1) return
        viewModelScope.launch(Dispatchers.IO) {
            if (isPinned.value) {
                noteRepository.unpinNote(noteId)
            } else {
                noteRepository.pinNote(noteId)
            }
        }
    }
}
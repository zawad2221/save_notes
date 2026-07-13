package com.example.notes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.repository.NoteRepository
import com.example.commonui.state.NoteListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    val noteListUiState: StateFlow<NoteListUiState> =
        noteRepository.getAllNotes().flatMapLatest { notes ->
            if (notes.isEmpty()) {
                flowOf(NoteListUiState.Empty)
            } else {
                flowOf(NoteListUiState.Success(notes))
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = NoteListUiState.Loading
        )
    private val _selectedNotes = MutableStateFlow<Set<Int>>(emptySet())
    val selectedNotes: StateFlow<Set<Int>> = _selectedNotes

    private val _isSelectionMode = MutableStateFlow<Boolean>(false)
    val isSelectionMode: StateFlow<Boolean> = _isSelectionMode

    val isAllSelectedNotesPinned: StateFlow<Boolean> = combine(
        _selectedNotes,
        noteRepository.pinnedNoteIds
    ) { selected, pinned ->
        selected.isNotEmpty() && selected.all { pinned.contains(it) }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = false
    )

    fun selectNote(noteId: Int) {
        _selectedNotes.value = _selectedNotes.value.toMutableSet().apply {
            if (!contains(noteId)) {
                add(noteId)
            } else {
                remove(noteId)
            }
        }
        _isSelectionMode.value = _selectedNotes.value.isNotEmpty()
    }

    fun clearSelection() {
        _selectedNotes.value = emptySet()
        _isSelectionMode.value = false
    }

    fun deleteSelectedNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            _selectedNotes.value.forEach { noteId ->
                noteRepository.deleteNoteById(noteId)
            }
            clearSelection()
        }
    }

    fun pinSelectedNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val allPinned = isAllSelectedNotesPinned.value
            _selectedNotes.value.forEach { noteId ->
                if (allPinned) {
                    noteRepository.unpinNote(noteId)
                } else {
                    noteRepository.pinNote(noteId)
                }
            }
            clearSelection()
        }
    }
}

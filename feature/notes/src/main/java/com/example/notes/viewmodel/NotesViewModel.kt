package com.example.notes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.repository.NoteRepository
import com.example.notes.state.NoteEditUiState
import com.example.notes.state.NoteListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
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
}

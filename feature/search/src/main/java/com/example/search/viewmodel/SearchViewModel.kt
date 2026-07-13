package com.example.search.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.commonui.state.NoteListUiState
import com.example.notes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val noteRepository: NoteRepository
) : ViewModel() {
    val searchQuery = savedStateHandle.getStateFlow(key = SEARCH_QUERY, initialValue = "")

    val searchResult: StateFlow<NoteListUiState> = searchQuery.flatMapLatest { query ->
        if (query.trim().length < SEARCH_QUERY_MIN_LENGTH) {
            flowOf(NoteListUiState.Empty)
        } else {
            noteRepository.searchNotes(query).flatMapLatest {
                if (it.isEmpty()) {
                    flowOf(NoteListUiState.Empty)
                } else {
                    flowOf(NoteListUiState.Success(it))
                }
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = NoteListUiState.Loading
    )


    fun onSearchQueryChanged(query: String) {
        savedStateHandle[SEARCH_QUERY] = query
    }

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
            _selectedNotes.value.forEach { noteId ->
                noteRepository.pinNote(noteId)
            }
            clearSelection()
        }
    }
}

private const val SEARCH_QUERY = "search_query"
private const val SEARCH_QUERY_MIN_LENGTH = 2
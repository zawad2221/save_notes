package com.example.notes.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor() : ViewModel() {
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

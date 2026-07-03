package com.example.notes.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.constants.NoteConstants
import com.example.notes.model.NoteModel
import com.example.notes.state.NoteEditUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NoteEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val noteToEditId =
        savedStateHandle.getStateFlow(key = NoteConstants.NOTE_ID, initialValue = -1)

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
        //todo: save or update note
    }

    fun getNote(noteId: Int) = flow {
        //todo: fetch data from repository
        emit(NoteModel(noteId, "Text Note Title", "Test note Content"))
    }
}

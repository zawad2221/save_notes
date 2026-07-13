package com.example.datastore

import androidx.datastore.core.DataStore
import com.example.datastore_proto.PinnedNotesProto
import com.example.datastore_proto.copy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PinNoteDataSource @Inject constructor(
    private val dataStore: DataStore<PinnedNotesProto>
) {
    val pinnedNoteIds: Flow<Set<Int>> = dataStore.data
        .map { it.pinnedNoteIdsList.toSet() }

    suspend fun pinNote(noteId: Int) {
        dataStore.updateData { currentPreferences ->
            currentPreferences.copy {
                if (!pinnedNoteIds.contains(noteId)) {
                    pinnedNoteIds.add(noteId)
                }
            }
        }
    }

    suspend fun unpinNote(noteId: Int) {
        dataStore.updateData { currentPreferences ->
            currentPreferences.copy {
                val updatedList = pinnedNoteIds.filter { it != noteId }
                pinnedNoteIds.clear()
                pinnedNoteIds.addAll(updatedList)
            }
        }
    }

    suspend fun isNotePinned(noteId: Int): Boolean {
        return dataStore.data.first().pinnedNoteIdsList.contains(noteId)
    }
}
package com.example.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.example.datastore_proto.PinnedNotesProto
import com.example.datastore_proto.serializer.PinnedNotesSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideProtoDataStore(@ApplicationContext context: Context): DataStore<PinnedNotesProto> {
        return DataStoreFactory.create(
            serializer = PinnedNotesSerializer,
            produceFile = { context.dataStoreFile("pinned_notes.pb") }
        )
    }
}
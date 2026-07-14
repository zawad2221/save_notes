package com.example.data.di

import com.example.data.repository.NoteRepository
import com.example.data.repository.NoteRepositoryImpl
import com.example.data.repository.UserPrefRepository
import com.example.data.repository.UserPrefRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NoteRepositoryModule {
    @Binds
    abstract fun bindNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository

    @Binds
    abstract fun bindUserPrefRepository(userPrefRepositoryImpl: UserPrefRepositoryImpl): UserPrefRepository
}

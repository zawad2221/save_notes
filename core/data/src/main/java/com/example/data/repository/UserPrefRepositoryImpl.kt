package com.example.data.repository

import com.example.datastore.UserPreferencesDataSource
import com.example.model.ThemeConfig
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserPrefRepositoryImpl @Inject constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource
) : UserPrefRepository {
    override val themeConfig: Flow<ThemeConfig> = userPreferencesDataSource.themeConfig

    override suspend fun setThemeConfig(themeConfig: ThemeConfig) {
        userPreferencesDataSource.setThemeConfig(themeConfig)
    }
}
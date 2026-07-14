package com.example.data.repository

import com.example.model.ThemeConfig
import kotlinx.coroutines.flow.Flow

interface UserPrefRepository {
    val themeConfig: Flow<ThemeConfig>

    suspend fun setThemeConfig(themeConfig: ThemeConfig)
}
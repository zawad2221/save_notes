package com.example.datastore

import androidx.datastore.core.DataStore
import com.example.datastore_proto.ThemeConfigProto
import com.example.datastore_proto.UserPreferencesProto
import com.example.datastore_proto.copy
import com.example.model.ThemeConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesDataSource @Inject constructor(
    private val dataStore: DataStore<UserPreferencesProto>
) {
    val themeConfig: Flow<ThemeConfig> = dataStore.data
        .map {
            when (it.themeConfig) {
                ThemeConfigProto.THEME_CONFIG_LIGHT -> ThemeConfig.LIGHT
                ThemeConfigProto.THEME_CONFIG_DARK -> ThemeConfig.DARK
                else -> ThemeConfig.SYSTEM
            }
        }

    suspend fun setThemeConfig(themeConfig: ThemeConfig) {
        dataStore.updateData { currentPreferences ->
            currentPreferences.copy {
                this.themeConfig = when (themeConfig) {
                    ThemeConfig.LIGHT -> ThemeConfigProto.THEME_CONFIG_LIGHT
                    ThemeConfig.DARK -> ThemeConfigProto.THEME_CONFIG_DARK
                    ThemeConfig.SYSTEM -> ThemeConfigProto.THEME_CONFIG_SYSTEM
                }
            }
        }
    }
}

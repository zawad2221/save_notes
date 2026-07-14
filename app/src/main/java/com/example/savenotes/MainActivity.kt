package com.example.savenotes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.base.BaseComposeActivity
import com.example.design_system.theme.NotesDefaultTheme
import com.example.model.ThemeConfig
import com.example.savenotes.navigation.NoteNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseComposeActivity() {
    lateinit var navHOstController: NavHostController
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableFullScreenView()
        setContent {
            val themeConfig by viewModel.themeConfig.collectAsStateWithLifecycle()
            val darkTheme = when (themeConfig) {
                ThemeConfig.SYSTEM -> isSystemInDarkTheme()
                ThemeConfig.LIGHT -> false
                ThemeConfig.DARK -> true
            }

            navHOstController = rememberNavController()
            NotesDefaultTheme(darkTheme = darkTheme) {
                NoteNavHost(
                    navController = navHOstController
                )
            }
        }
    }
}
package com.example.savenotes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.base.BaseComposeActivity
import com.example.design_system.theme.NotesDefaultTheme
import com.example.savenotes.navigation.NoteNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseComposeActivity() {
    lateinit var navHOstController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableFullScreenView()
        setContent {
            navHOstController = rememberNavController()
            NotesDefaultTheme {
                NoteNavHost(
                    navController = navHOstController
                )
            }
        }
    }
}
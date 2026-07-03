package com.example.savenotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.base.BaseComposeActivity
import com.example.design_system.theme.CustomTheme
import com.example.design_system.theme.NotesDefaultTheme
import com.example.notes.navigation.NoteNavHost
import com.example.notes.sceens.NotesLandingScreen
import com.example.notes.viewmodel.NotesViewModel
import com.example.savenotes.ui.theme.SaveNotesTheme
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
package com.example.notes.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.design_system.theme.CustomTheme
import com.example.notes.sceens.NoteAddEditScreen
import com.example.notes.sceens.NotesLandingScreen
import com.example.notes.viewmodel.NotesViewModel

@Composable
fun NoteNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = NoteScreen.LANDING.value
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = CustomTheme.colors.WhiteAlpha100
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier.padding(paddingValues)
        ) {
            composable(route = NoteScreen.LANDING.value) {
                NotesLandingScreen(
                    onNoteClicked = {
                        navController.navigate("${NoteScreen.EDIT_NOTE.value}/$it")
                    },
                    onAddNoteClicked = {
                        navController.navigate("${NoteScreen.EDIT_NOTE.value}/-1")
                    }
                )
            }
            composable(
                route = "${NoteScreen.EDIT_NOTE.value}/{noteId}",
                arguments = listOf(navArgument("noteId") { type = NavType.IntType })
            ) {
                val noteId = it.arguments?.getInt("noteId") ?: -1
                NoteAddEditScreen(
                    noteId = noteId
                ) {
                    navController.popBackStack()
                }
            }
        }
    }
}
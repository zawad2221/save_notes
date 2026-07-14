package com.example.savenotes.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import com.example.search.screens.SearchScreen

@Composable
fun NoteNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = NoteScreen.LANDING.value
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = CustomTheme.colors.BackgroundPrimary
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
                    },
                    onSearchClicked = {
                        navController.navigate(NoteScreen.SEARCH.value)
                    }
                )
            }
            composable(
                route = "${NoteScreen.EDIT_NOTE.value}/{noteId}",
                arguments = listOf(navArgument("noteId") { type = NavType.IntType }),
                enterTransition = {
                    scaleIn(animationSpec = tween(400), initialScale = 0.8f) + fadeIn(animationSpec = tween(400))
                },
                exitTransition = {
                    scaleOut(animationSpec = tween(400), targetScale = 0.8f) + fadeOut(animationSpec = tween(400))
                },
                popEnterTransition = {
                    scaleIn(animationSpec = tween(400), initialScale = 0.8f) + fadeIn(animationSpec = tween(400))
                },
                popExitTransition = {
                    scaleOut(animationSpec = tween(400), targetScale = 0.8f) + fadeOut(animationSpec = tween(400))
                }
            ) {
                val noteId = it.arguments?.getInt("noteId") ?: -1
                NoteAddEditScreen(
                    noteId = noteId
                ) {
                    navController.popBackStack()
                }
            }
            composable(
                route = NoteScreen.SEARCH.value
            ) {
                SearchScreen(
                    onNoteClicked = {
                        navController.navigate("${NoteScreen.EDIT_NOTE.value}/$it")
                    },
                    onBackAction = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
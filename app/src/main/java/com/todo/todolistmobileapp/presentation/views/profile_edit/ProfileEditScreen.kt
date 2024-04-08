package com.todo.todolistmobileapp.presentation.views.profile_edit

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.components.DefaultTopBar
import com.todo.todolistmobileapp.presentation.views.profile_edit.components.ProfileEditContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(title = "Actualizar", upAvailable = true, navController = navController)
        },
        content = {

            ProfileEditContent(navController)
        },
        bottomBar = {}
    )
}
package com.todo.todolistmobileapp.presentation.views.profile_edit

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.components.DefaultTopBar
import com.todo.todolistmobileapp.presentation.views.profile_edit.components.ProfileEditContent
import com.todo.todolistmobileapp.presentation.views.profile_edit.components.Update

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(navController: NavHostController, user: String) {

    // Log.d("ProfileEditLog", "Usuario:$user")
    Scaffold(
        topBar = {
            DefaultTopBar(title = "Actualizar", upAvailable = true, navController = navController)
        },
        content = {

            ProfileEditContent(navController)
        },
        bottomBar = {}
    )
    Update()
}
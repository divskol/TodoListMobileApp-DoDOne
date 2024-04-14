package com.todo.todolistmobileapp.presentation.views.profile



import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.screens.profile.components.ProfileContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {},
        content = {
            ProfileContent(navController)
        },
        bottomBar = {}
    )

}
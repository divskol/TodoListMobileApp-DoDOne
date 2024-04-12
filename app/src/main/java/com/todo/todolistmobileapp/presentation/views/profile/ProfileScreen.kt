package com.todo.todolistmobileapp.presentation.views.profile


import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.views.profile.components.ProfileContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {},
        content = {
            ProfileContent(navController)
        },
        bottomBar = {})
}
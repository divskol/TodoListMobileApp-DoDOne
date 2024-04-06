package com.todo.todolistmobileapp.presentation.views.profile


import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.components.DefaultButton
import com.todo.todolistmobileapp.presentation.navigation.AppScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {},
        content = {
            DefaultButton(
                text = "Cerrar sesión",
                description = "Cerrar session actual",
                onClick = {
                    viewModel.logout()
                    navController.navigate(route = AppScreen.Login.route) {
                        popUpTo(AppScreen.Profile.route) { inclusive = true }
                    }
                })
        },
        bottomBar = {})
}
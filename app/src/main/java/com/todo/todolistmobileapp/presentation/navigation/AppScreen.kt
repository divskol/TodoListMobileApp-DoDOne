package com.todo.todolistmobileapp.presentation.navigation

sealed class AppScreen(val route: String) {
    object Login : AppScreen("login")
    object Signup : AppScreen("signaup")
    object Profile : AppScreen("profile")
}
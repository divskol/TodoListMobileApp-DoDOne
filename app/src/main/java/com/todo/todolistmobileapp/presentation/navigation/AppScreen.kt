package com.todo.todolistmobileapp.presentation.navigation

sealed class AppScreen(val route: String) {
    object Login : AppScreen("login")
    object Signup : AppScreen("signaup")
    object Profile : AppScreen("profile")
    object ProfileEdit : AppScreen("profile/edit/{user}") {
        fun passUser(user: String) = "profile/edit/$user"
    }
}
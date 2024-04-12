package com.todo.todolistmobileapp.presentation.navigation

sealed class RootScreen(val route: String) {
    object Home : RootScreen("home")
}
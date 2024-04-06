package com.todo.todolistmobileapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.todo.todolistmobileapp.presentation.views.login.LoginScreen
import com.todo.todolistmobileapp.presentation.views.profile.ProfileScreen
import com.todo.todolistmobileapp.presentation.views.signup.SignupScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {
        composable(route = AppScreen.Login.route) {
            LoginScreen(navController)
        }

        composable(route = AppScreen.Signup.route) {
            SignupScreen(navController)
        }
        composable(route = AppScreen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
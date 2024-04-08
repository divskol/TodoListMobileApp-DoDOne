package com.todo.todolistmobileapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.todo.todolistmobileapp.presentation.views.login.LoginScreen
import com.todo.todolistmobileapp.presentation.views.profile.ProfileScreen
import com.todo.todolistmobileapp.presentation.views.profile_edit.ProfileEditScreen
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
        composable(route = AppScreen.ProfileEdit.route, arguments = listOf(navArgument("user") {
            type = NavType.StringType
        })) {
            it.arguments?.getString("user")?.let {

                ProfileEditScreen(navController, user = it)
            }
        }
    }
}
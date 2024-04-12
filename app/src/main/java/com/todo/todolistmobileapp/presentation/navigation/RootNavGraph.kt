package com.todo.todolistmobileapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.todo.todolistmobileapp.presentation.views.home.HomeScreen
import com.todo.todolistmobileapp.presentation.views.profile.ProfileScreen
import com.todo.todolistmobileapp.presentation.views.profile_edit.ProfileEditScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController)

        composable(route = RootScreen.Home.route) {
            HomeScreen()
        }

        composable(route = AuthScreen.ProfileEdit.route, arguments = listOf(navArgument("user") {
            type = NavType.StringType
        })) {
            it.arguments?.getString("user")?.let {
                ProfileEditScreen(navController, user = it)
            }
        }
    }
}
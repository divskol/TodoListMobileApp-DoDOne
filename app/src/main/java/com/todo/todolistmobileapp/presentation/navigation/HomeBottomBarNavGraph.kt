package com.todo.todolistmobileapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.todo.todolistmobileapp.presentation.views.myposts.MyPostsScreen
import com.todo.todolistmobileapp.presentation.views.posts.PostsScreen
import com.todo.todolistmobileapp.presentation.views.profile.ProfileScreen

@Composable
fun HomeBottomBarNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeBottomBarScreen.Posts.route
    ) {
        composable(route = HomeBottomBarScreen.Posts.route) {
            PostsScreen(navController)
        }
        composable(route = HomeBottomBarScreen.MyPosts.route) {
            MyPostsScreen(navController)
        }
        composable(route = HomeBottomBarScreen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
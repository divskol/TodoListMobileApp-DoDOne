package com.todo.todolistmobileapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.todo.todolistmobileapp.presentation.views.my_posts.MyPostsScreen
import com.todo.todolistmobileapp.presentation.views.posts.PostsScreen
import com.todo.todolistmobileapp.presentation.views.profile.ProfileScreen

@Composable
fun HomeBottomBarNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = HomeBottomBarScreen.MyPosts.route
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

        detailsNavGraph(navController)

    }
}


sealed class HomeBottomBarScreen(
    val route: String,
    var title: String,
    val icon: ImageVector
) {

    object Posts: HomeBottomBarScreen(
        route = "posts",
        title = "All task",
        icon = Icons.Default.Check
    )

    object MyPosts: HomeBottomBarScreen(
        route = "my_posts",
        title = "New tasks",
        icon = Icons.Outlined.List
    )

    object Profile: HomeBottomBarScreen(
        route = "profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}
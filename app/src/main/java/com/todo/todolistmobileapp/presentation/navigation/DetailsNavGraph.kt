package com.todo.todolistmobileapp.presentation.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.todo.todolistmobileapp.presentation.views.detail_post.DetailPostScreen
import com.todo.todolistmobileapp.presentation.views.new_post.NewPostScreen
import com.todo.todolistmobileapp.presentation.views.profile_edit.ProfileEditScreen
import com.todo.todolistmobileapp.presentation.views.update_post.UpdatePostScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {

    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.ProfileUpdate.route
    ) {

        composable(route = DetailsScreen.NewPost.route) {
            NewPostScreen(navController = navController)
        }

        composable(
            route = DetailsScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileEditScreen(navController, user = it)
            }
        }

        composable(
            route = DetailsScreen.DetailPost.route,
            arguments = listOf(navArgument("post"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("post")?.let {
                DetailPostScreen(navController, post = it)
            }
        }

        composable(
            route = DetailsScreen.UpdatePost.route,
            arguments = listOf(navArgument("post"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("post")?.let {
                UpdatePostScreen(navController, post = it)
            }
        }
    }

}

sealed class DetailsScreen(val route: String) {

    object NewPost: DetailsScreen("posts/new")
    object ProfileUpdate: DetailsScreen("profile/edit/{user}") {
        fun passUser(user: String) = "profile/edit/$user"
    }
    object DetailPost: DetailsScreen("posts/detail/{post}") {
        fun passPost(post: String) = "posts/detail/$post"
    }
    object UpdatePost: DetailsScreen("posts/update/{post}") {
        fun passPost(post: String) = "posts/update/$post"
    }

}
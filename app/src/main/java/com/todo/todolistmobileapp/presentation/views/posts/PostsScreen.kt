package com.todo.todolistmobileapp.presentation.views.posts

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.views.posts.components.GetPosts
import com.todo.todolistmobileapp.presentation.views.posts.components.DeleteLikePost
import com.todo.todolistmobileapp.presentation.views.posts.components.LikePost

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PostsScreen(navController: NavHostController, viewModel: PostsViewModel = hiltViewModel()) {

    Scaffold(
        content = {
            GetPosts(navController)
        }
    )
    LikePost()
    DeleteLikePost()

}
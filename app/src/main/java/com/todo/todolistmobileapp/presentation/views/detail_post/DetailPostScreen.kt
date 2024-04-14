package com.todo.todolistmobileapp.presentation.views.detail_post

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.navigation.DetailsScreen
import com.todo.todolistmobileapp.presentation.screens.detail_post.components.DetailPostContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailPostScreen(navController: NavHostController, post: String) {
    Scaffold(
        content = {
            DetailPostContent(navController)
        }
    )
}
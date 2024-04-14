package com.todo.todolistmobileapp.presentation.views.new_post

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.components.DefaultButton
import com.todo.todolistmobileapp.presentation.components.DefaultTopBar
import com.todo.todolistmobileapp.presentation.views.new_post.components.NewPost
import com.todo.todolistmobileapp.presentation.views.new_post.components.NewPostContent
import com.todo.todolistmobileapp.presentation.views.new_post.NewPostViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewPostScreen(navController: NavHostController, viewModel: NewPostViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo Post",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            NewPostContent()
        },
        bottomBar = {
//            DefaultButton(
//                text = "PUBLICAR",
//                onClick = { viewModel.onNewPost() }
//            )
            DefaultButton(
                text = "Publicar",
                description = "publicar",
                icon = Icons.Default.Edit,
                onClick = { viewModel.onNewPost() })
        }
    )
    NewPost()

}
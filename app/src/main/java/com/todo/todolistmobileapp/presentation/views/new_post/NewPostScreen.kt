package com.todo.todolistmobileapp.presentation.views.new_post

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.components.DefaultButton
import com.todo.todolistmobileapp.presentation.components.DefaultTopBar
import com.todo.todolistmobileapp.presentation.views.new_post.components.NewPost
import com.todo.todolistmobileapp.presentation.views.new_post.components.NewPostContent

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
            Column( modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally) {

                DefaultButton(
                    text = "Publicar",
                    description = "publicar",
                    icon = Icons.Default.Edit,
                    onClick = { viewModel.onNewPost() })
            }
        }
    )
    NewPost()

}
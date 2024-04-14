package com.todo.todolistmobileapp.presentation.views.update_post

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.components.DefaultButton
import com.todo.todolistmobileapp.presentation.components.DefaultTopBar
import com.todo.todolistmobileapp.presentation.views.new_post.components.NewPost
import com.todo.todolistmobileapp.presentation.views.new_post.components.NewPostContent
import com.todo.todolistmobileapp.presentation.views.update_post.components.UpdatePost
import com.todo.todolistmobileapp.presentation.views.update_post.components.UpdatePostContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun UpdatePostScreen(
    navController: NavHostController,
    post: String,
    viewModel: UpdatePostViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar Post",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            UpdatePostContent()
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                DefaultButton(
                    text = "Actualizar", description = "Ingresar a la app",
                    onClick = { viewModel.onUpdatePost() },

                    )
            }
        }
    )
    UpdatePost()

}
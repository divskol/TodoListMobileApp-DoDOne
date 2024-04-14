package com.todo.todolistmobileapp.presentation.views.new_post.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.presentation.components.ProgressBar
import com.todo.todolistmobileapp.presentation.views.new_post.NewPostViewModel

@Composable
fun NewPost(viewModel: NewPostViewModel = hiltViewModel()) {

    when(val response = viewModel.createPostResponse) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Response.Loading -> {
            ProgressBar()
        }
        is Response.Success -> {
            viewModel.clearForm()
            Toast.makeText(LocalContext.current, "La publicacion se ha creado correctamente", Toast.LENGTH_LONG).show()
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconido", Toast.LENGTH_LONG).show()
        }
        else->{

        }

    }

}
package com.todo.todolistmobileapp.presentation.views.profile_edit.components

import android.widget.Toast
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.presentation.components.ProgressBar
import com.todo.todolistmobileapp.presentation.views.profile_edit.ProfileEditViewModel

@Composable
fun SaveImage(viewModel: ProfileEditViewModel = hiltViewModel()) {

    when (val response = viewModel.saveImageResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            viewModel.onUpdate(response.data)
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                response.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()

        }

        else -> {

        }
    }
}
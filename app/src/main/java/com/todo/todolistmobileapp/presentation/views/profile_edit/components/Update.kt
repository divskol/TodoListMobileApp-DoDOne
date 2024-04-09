package com.todo.todolistmobileapp.presentation.views.profile_edit.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.presentation.components.ProgressBar
import com.todo.todolistmobileapp.presentation.views.profile_edit.ProfileEditViewModel

@Composable
fun Update(viewModel: ProfileEditViewModel = hiltViewModel()) {
    when (val updateResponse = viewModel.updateResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
//            LaunchedEffect(Unit) {
//                Toast.makeText(
//                    LocalContext.current,
//                    "Usuario Logeado",
//                    Toast.LENGTH_LONG
//                ).show()
//            }

            Log.d("verificar", "jasdasnk")
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                updateResponse.exception?.message ?: "error",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {
            // When response is neither Loading, Success, nor Failure
        }
    }
}

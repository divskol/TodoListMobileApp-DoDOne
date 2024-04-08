package com.todo.todolistmobileapp.presentation.views.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.presentation.components.ProgressBar
import com.todo.todolistmobileapp.presentation.navigation.AppScreen
import com.todo.todolistmobileapp.presentation.views.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
    when (val loginResponse = viewModel.loginResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = AppScreen.Profile.route) {
                    popUpTo(AppScreen.Login.route) {
                        inclusive = true
                    }
                }
            }
//                Toast.makeText(LocalContext.current, "Usuario Logeado", Toast.LENGTH_LONG).show()
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                loginResponse.exception?.message ?: "Error ingreso",
                Toast.LENGTH_LONG
            ).show()

        }

        else -> {

        }
    }

}
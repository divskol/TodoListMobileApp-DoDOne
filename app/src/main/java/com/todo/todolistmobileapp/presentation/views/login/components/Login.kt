package com.todo.todolistmobileapp.presentation.views.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.presentation.components.ProgressBar
import com.todo.todolistmobileapp.presentation.navigation.AuthScreen
import com.todo.todolistmobileapp.presentation.navigation.Graph
import com.todo.todolistmobileapp.presentation.navigation.RootScreen
import com.todo.todolistmobileapp.presentation.views.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
    when (val loginResponse = viewModel.loginResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(route = RootScreen.Home.route) {
                    popUpTo(Graph.AUTHENTICATION) {
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
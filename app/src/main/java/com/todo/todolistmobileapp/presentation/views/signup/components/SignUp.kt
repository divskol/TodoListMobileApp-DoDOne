package com.todo.todolistmobileapp.presentation.views.signup.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.presentation.components.ProgressBar
import com.todo.todolistmobileapp.presentation.navigation.AppScreen
import com.todo.todolistmobileapp.presentation.views.signup.SignupViewModel

@Composable
fun SignUp(navController: NavHostController, viewModel: SignupViewModel = hiltViewModel()) {
    when (val signupResponse = viewModel.signupResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            LaunchedEffect(Unit) {
                viewModel.createUser()

                // Recibe la ruta inicial con la que corre la app
                navController.popBackStack(AppScreen.Login.route, inclusive = true)
                navController.navigate(route = AppScreen.Profile.route)
            }
//            Toast.makeText(LocalContext.current, "Usuario Logeado", Toast.LENGTH_LONG).show()
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                signupResponse.exception?.message ?: "Error ingreso",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {
            //Cuando response no es Response.Loading
        }
    }

}
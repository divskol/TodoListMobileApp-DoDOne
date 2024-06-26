package com.todo.todolistmobileapp.presentation.views.login

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.todo.todolistmobileapp.presentation.views.login.components.Login
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme
import com.todo.todolistmobileapp.presentation.views.login.components.LoginBottomBar
import com.todo.todolistmobileapp.presentation.views.login.components.LoginContent


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavHostController) {

    Scaffold(
        topBar = {},
        content = { LoginContent(navController) },
        bottomBar = { LoginBottomBar(navController) }
    )
// Manejo de estado petición login
    Login(navController = navController)
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TodoListMobileAppTheme {
        LoginScreen(rememberNavController())
    }
}
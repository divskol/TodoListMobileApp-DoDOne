package com.todo.todolistmobileapp.presentation.views.login

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme
import com.todo.todolistmobileapp.presentation.views.login.components.LoginBottomBar
import com.todo.todolistmobileapp.presentation.views.login.components.LoginContent


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {},
        content = { LoginContent() },
        bottomBar = { LoginBottomBar() }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TodoListMobileAppTheme {
        LoginScreen()
    }
}
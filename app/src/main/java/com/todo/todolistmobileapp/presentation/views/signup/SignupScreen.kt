package com.todo.todolistmobileapp.presentation.views.signup

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.todo.todolistmobileapp.presentation.views.login.LoginScreen
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignupScreen() {

    Scaffold(
        topBar = {},
        content = {
            Text(text = "gdfg")
        },
        bottomBar = {}
    )


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TodoListMobileAppTheme {
        SignupScreen()
    }
}
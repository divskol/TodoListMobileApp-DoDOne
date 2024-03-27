package com.todo.todolistmobileapp.presentation.views.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.todo.todolistmobileapp.presentation.components.DefaultTopBar
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignupScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo usuario",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            Text(text = "gdfg")
        },
        bottomBar = {}
    )


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignupScreen() {
    TodoListMobileAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            SignupScreen(rememberNavController())
        }
    }
}


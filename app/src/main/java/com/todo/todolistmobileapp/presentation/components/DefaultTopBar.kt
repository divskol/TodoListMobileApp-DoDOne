package com.todo.todolistmobileapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.todo.todolistmobileapp.presentation.views.signup.SignupScreen
import com.todo.todolistmobileapp.ui.theme.Blue700
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String, upAvailable: Boolean = false, navController: NavHostController? = null
) {
    TopAppBar(
        title = {
            Text(text = title, fontSize = 19.sp)
        },
        Modifier.background(Color.Blue),
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = { navController?.popBackStack() }) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver a la pantalla anterior",
                    )

                }
            }
        }

    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTop() {
    TodoListMobileAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            DefaultTopBar(title = "fdsf", upAvailable = true, rememberNavController())
        }
    }
}



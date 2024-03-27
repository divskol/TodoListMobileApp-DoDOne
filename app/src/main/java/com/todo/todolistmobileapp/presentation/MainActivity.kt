package com.todo.todolistmobileapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.todo.todolistmobileapp.presentation.navigation.AppNavigation
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme

class MainActivity : ComponentActivity() {


    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListMobileAppTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    navController = rememberNavController()
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}

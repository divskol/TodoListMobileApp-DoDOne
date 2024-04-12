package com.todo.todolistmobileapp.presentation.views.myposts

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyPostsScreen(navController: NavHostController) {
    Scaffold(
        content = {
        Text(text = "My PostScreen")
        }
    )
}
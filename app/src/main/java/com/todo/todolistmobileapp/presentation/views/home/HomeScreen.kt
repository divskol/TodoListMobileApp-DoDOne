package com.todo.todolistmobileapp.presentation.views.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.todo.todolistmobileapp.presentation.navigation.HomeBottomBarNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold() {
        HomeBottomBarNavGraph(navController = navController)
    }
}
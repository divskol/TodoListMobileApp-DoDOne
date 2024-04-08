package com.todo.todolistmobileapp.presentation.views.profile.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.presentation.components.DefaultButton
import com.todo.todolistmobileapp.presentation.navigation.AppScreen
import com.todo.todolistmobileapp.presentation.views.profile.ProfileViewModel
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme

@Composable
fun ProfileContent(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                painter = painterResource(
                    id = R.drawable.foto1
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alpha = 0.3f
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                Text(
                    text = "Bienvenido",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(60.dp))

                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = painterResource(
                        id = R.drawable.logo
                    ),
                    contentDescription = "",

                    )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = viewModel.userData.username,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = viewModel.userData.email,
            fontSize = 15.sp,
        )
        Spacer(modifier = Modifier.height(30.dp))

        DefaultButton(
            text = "Editar info",
            description = "Cerrar session actual",
            icon = Icons.Default.Edit,
            onClick = {
                navController.navigate(AppScreen.ProfileEdit.route)
            })
        DefaultButton(
            text = "Cerrar sesión",
            icon = Icons.Default.Clear,
            description = "Cerrar session actual",

            onClick = {
                viewModel.logout()
                navController.navigate(route = AppScreen.Login.route) {
                    popUpTo(AppScreen.Profile.route) { inclusive = true }
                }
            })
    }
}


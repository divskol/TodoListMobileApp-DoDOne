package com.todo.todolistmobileapp.presentation.screens.profile.components


import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.presentation.MainActivity
import com.todo.todolistmobileapp.presentation.components.DefaultButton
import com.todo.todolistmobileapp.presentation.navigation.AuthScreen
import com.todo.todolistmobileapp.presentation.navigation.DetailsScreen
import com.todo.todolistmobileapp.presentation.navigation.Graph
import com.todo.todolistmobileapp.presentation.views.profile.ProfileViewModel
@Composable
fun ProfileContent(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {

    val activity = LocalContext.current as? Activity

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box() {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alpha = 0.6f
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Bienvenido",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(55.dp))
                if (viewModel.userData.image != "") {
                    AsyncImage(
                        modifier = Modifier
                            .size(115.dp)
                            .clip(CircleShape),
                        model = viewModel.userData.image,
                        contentDescription = "User image",
                        contentScale = ContentScale.Crop
                    )
                }
                else {
                    Image(
                        modifier = Modifier.size(115.dp),
                        painter = painterResource(id = R.drawable.user1),
                        contentDescription = ""
                    )
                }

            }

        }

        Spacer(modifier = Modifier.height(55.dp))
        Text(
            text = viewModel.userData.username,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = viewModel.userData.email,
            fontSize = 15.sp,
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(20.dp))
        DefaultButton(
            text = "Editar info",
            description = "Cerrar session actual",
            icon = Icons.Default.Edit,

            onClick = {
                navController.navigate(
                    route = DetailsScreen.ProfileUpdate.passUser(viewModel.userData.toJson())
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        DefaultButton(
            text = "Cerrar sesión",
            icon = Icons.Default.Clear,
            description = "Cerrar session actual",

            onClick = {
                viewModel.logout()
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            }
        )

    }

}

package com.todo.todolistmobileapp.presentation.views.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.presentation.components.DefaultButton
import com.todo.todolistmobileapp.presentation.components.DefaultTextField
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.todo.todolistmobileapp.presentation.views.login.LoginViewModel

@Composable
fun LoginContent(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {

    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .wrapContentHeight()
            .padding(12.dp)
    ) {


        Box(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),


            ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    modifier = Modifier.height(180.dp),
                    painter = painterResource(id = R.drawable.foto1),
                    contentDescription = "Control de inicio"
                )

                Text(text = "TODO LIST RD", fontSize = 40.sp, color = Color.Black)
            }

        }

        Card(
            modifier = Modifier.padding(start = 30.dp, end = 30.dp)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {

                Column(
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(15.dp)
                ) {

                    Text(
                        text = "LOGIN",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Left
                    )
                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Por favor inicia sesión para continuar", fontSize = 10.sp
                    )
                }

                DefaultTextField(
                    modifier = Modifier.padding(top = 25.dp),
                    value = state.email,
                    onValueChange = { viewModel.onEmailInput(it) },
                    label = "Email",
                    icon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    errorMsg = viewModel.emailErrMsg,
                    validateField = {
                        viewModel.validateEmail()
                    }
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 25.dp),
                    value = state.password,
                    onValueChange = { viewModel.onPasswordInput(it) },
                    label = "Password",
                    icon = Icons.Default.Lock,
                    hideText = true,
                    errorMsg = viewModel.passwordlErrMsg,
                    validateField = {
                        viewModel.validatePassword()
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                DefaultButton(
                    text = "Ingresar", description = "Ingresar a la app",
                    onClick = {
                        viewModel.login()
                    },
                    enabled = viewModel.isEnabledLoginButton
                )
            }
        }
    }

}


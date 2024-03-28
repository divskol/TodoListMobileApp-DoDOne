package com.todo.todolistmobileapp.presentation.views.signup.components

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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.presentation.components.DefaultButton
import com.todo.todolistmobileapp.presentation.components.DefaultTextField
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun SignupContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .wrapContentHeight()
            .padding(12.dp),
    ) {


        BoxHeader()
        CardForm()

    }
}


@Composable
fun BoxHeader() {
    Box(
        modifier = Modifier
            .height(230.dp)
            .fillMaxWidth(),


        ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.height(120.dp),
                painter = painterResource(id = R.drawable.inicio),
                contentDescription = "Control de inicio"
            )

        }

    }
}

@Composable
fun CardForm() {

    var username by remember {
        mutableStateOf("")

    }

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    Card(
        modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 1.dp)
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
                    text = "REGISTRO",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Por favor ingresa estos datos para continuar", fontSize = 10.sp
                )
            }

            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = username,
                onValueChange = { username = it },
                label = "Nombre de usuario",
                icon = Icons.Default.Person,
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = email,
                onValueChange = { email = it },
                label = "Email",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = password,
                onValueChange = { password = it },
                label = "Password",
                icon = Icons.Default.Lock,
                hideText = true
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Confirmar contraseña",
                icon = Icons.Outlined.Lock,
                hideText = true
            )


            Spacer(modifier = Modifier.height(10.dp))


            /*  OutlinedTextField(value = "", onValueChange = {}, label = {
                  Text(text = "Contraseña")
              }, leadingIcon = {
                  Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = Color.Gray)
              })*/
            DefaultButton(
                text = "Registrarme",
                description = "Registro de usuario",
                onClick = { })


        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignUpContent() {
    TodoListMobileAppTheme {
        SignupContent()
    }
}
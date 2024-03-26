package com.todo.todolistmobileapp.views.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme

@Composable
fun LoginContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .wrapContentHeight()
            .padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(130.dp),
            painter = painterResource(id = R.drawable.foto1),
            contentDescription = "Control de inicio"
        )

        Text(text = "INICIO TODO LIST")

        CardForm()

    }
}


@Composable
fun CardForm() {

    Card() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(modifier = Modifier
                .align(alignment = Alignment.Start)
                .padding(15.dp)) {

                Text(
                    text = "LOGIN",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Por favor inicia sesión para continuar",
                    fontSize = 15.sp
                )
            }


            OutlinedTextField(value = "", onValueChange = {}, label = {
                Text(text = "Correo")
            }, leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = Color.Gray)
            })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = "", onValueChange = {}, label = {
                Text(text = "Contraseña")
            }, leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = Color.Gray)
            })

            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp), onClick = { }) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    tint = Color.White
                )
                Text(text = "Iniciar ")
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TodoListMobileAppTheme {
        LoginContent()
    }
}
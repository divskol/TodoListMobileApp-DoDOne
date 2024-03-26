package com.todo.todolistmobileapp.views.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.ui.theme.TodoListMobileAppTheme

@Composable
fun LoginContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .wrapContentHeight()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(130.dp),
            painter = painterResource(id = R.drawable.foto1),
            contentDescription = "Control de inicio"
        )

        Text(text = "INICIO TODO LIST")

        Text(text = "LOGIN", modifier = Modifier.padding(20.dp))

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Por favor inicia sesión para continuar")

        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Correo")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Contraseña")
            }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            onClick = { }) {
            Text(text = "Iniciar sesión")
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
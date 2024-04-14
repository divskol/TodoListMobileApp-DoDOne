package com.todo.todolistmobileapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String, onValueChange: (value: String) -> Unit, label: String,
    icon: ImageVector, keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false,
    errorMsg: String = "",
    validateField: () -> Unit = {}
) {


    Column() {
        OutlinedTextField(value = value, onValueChange = {
            onValueChange(it)
            validateField()
        },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType), label = {
                Text(text = label, color = Color.Black)
            }, leadingIcon = {
                Icon(imageVector = icon, contentDescription = "", tint = Color.Gray)
            },
            visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
        )
        Text(
            text = errorMsg,
            modifier = Modifier.padding(5.dp),
            fontSize = 10.sp,

        )

    }
}
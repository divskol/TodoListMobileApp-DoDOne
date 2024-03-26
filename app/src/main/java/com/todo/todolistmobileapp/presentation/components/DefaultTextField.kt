package com.todo.todolistmobileapp.presentation.components

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

@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String, onValueChange: (value: String) -> Unit, label: String,
    icon: ImageVector, keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false
) {


    OutlinedTextField(value = value, onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType), label = {
            Text(text = label)
        }, leadingIcon = {
            Icon(imageVector = icon, contentDescription = "", tint = Color.Gray)
        },
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
    )
}
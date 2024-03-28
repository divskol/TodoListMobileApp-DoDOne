package com.todo.todolistmobileapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.todo.todolistmobileapp.ui.theme.Blue700

@Composable
fun DefaultButton(
    text: String,
    description: String,
    onClick: () -> Unit,
    color: Color = Blue700,
    icon: ImageVector = Icons.Default.ArrowForward,
    enabled: Boolean = true
) {

    Column {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            colors = ButtonDefaults.buttonColors(contentColor = color),
            onClick = { onClick() },
            enabled = enabled
        ) {
            Icon(
                imageVector = icon,
                contentDescription = description,
                tint = Color.White
            )
            Text(text = text, color = Color.White)
        }
    }
}
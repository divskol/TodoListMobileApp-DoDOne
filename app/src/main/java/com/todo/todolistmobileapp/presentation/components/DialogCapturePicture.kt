package com.todo.todolistmobileapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogCapturePicture(
    status: MutableState<Boolean>, takePhoto: () -> Unit, pickImage: () -> Unit
) {
    if (status.value) {
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            onDismissRequest = { status.value = false },
            title = {
                Text("Selecciona una opción")
            },
            text = {
                Text("¿Deseas abrir la cámara o tu galería?")
            },
            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            status.value = false
                            pickImage()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp)
                    ) {
                        Text("Galería")
                    }
                    Button(
                        onClick = {
                            status.value = false
                            takePhoto()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp)
                    ) {
                        Text("Cámara")
                    }
                }
            },
//            dismissButton = {
//                TextButton(
//                    onClick = { status.value = false },
//                    modifier = Modifier.padding(8.dp)
//                ) {
//                    Text("Cancelar")
//                }
//            }
        )
    }
}
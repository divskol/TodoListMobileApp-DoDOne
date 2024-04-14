package com.todo.todolistmobileapp.presentation.views.update_post.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.presentation.components.DefaultTextField
import com.todo.todolistmobileapp.presentation.components.DialogCapturePicture
import com.todo.todolistmobileapp.presentation.views.new_post.NewPostViewModel
import com.todo.todolistmobileapp.presentation.views.update_post.UpdatePostViewModel



@Composable
fun UpdatePostContent(viewModel: UpdatePostViewModel = hiltViewModel()) {

    val state = viewModel.state
    viewModel.resultingActivityHandler.handle()
    var dialogState = remember { mutableStateOf(false) }

    DialogCapturePicture(
        status = dialogState,
        takePhoto = { viewModel.takePhoto() },
        pickImage = { viewModel.pickImage() }
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()


    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .background(Color.White),
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (viewModel.state.image != "") {
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(170.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            model = viewModel.state.image,
                            contentDescription = "Selected image",
                            contentScale = ContentScale.Crop
                        )
                    }
                    else {
                        Image(
                            modifier = Modifier
                                .height(120.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            painter = painterResource(id = R.drawable.upload),
                            contentDescription = "Imagen de usuario"
                        )
                        Text(
                            text = "SUBE UNA IMAGEN",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

            }
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 20.dp, end = 20.dp),
                value = state.name,
                onValueChange = { viewModel.onNameInput(it) },
                label = "Nombre de la tarea",
                icon = Icons.Default.CheckCircle,
                errorMsg = "",
                validateField = {

                }
            )
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp, start = 20.dp, end = 20.dp),
                value = state.description,
                onValueChange = { viewModel.onDescriptionInput(it) },
                label = "Descripcion",
                icon = Icons.Default.List,
                errorMsg = "",
                validateField = {

                }
            )
            Text(
                modifier = Modifier.padding(vertical = 15.dp),
                text = "CATEGORIA",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            viewModel.radioOptions.forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .selectable(
                            selected = (option.category == state.category),
                            onClick = { viewModel.onCategoryInput(option.category) }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (option.category == state.category),
                        onClick = { viewModel.onCategoryInput(option.category) }
                    )
                    Row() {
                        Text(
                            modifier = Modifier
                                .padding(12.dp),
                            text = option.category
                        )
                        Image(
                            modifier = Modifier
                                .height(35.dp)
                                .padding(5.dp),
                            painter = painterResource(id = option.image),
                            contentDescription = ""
                        )
                    }
                }
            }
        }


    }
}

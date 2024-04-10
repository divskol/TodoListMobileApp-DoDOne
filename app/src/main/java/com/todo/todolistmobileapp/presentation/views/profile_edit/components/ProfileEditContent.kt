package com.todo.todolistmobileapp.presentation.views.profile_edit.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.presentation.components.DefaultButton
import com.todo.todolistmobileapp.presentation.components.DefaultTextField
import com.todo.todolistmobileapp.presentation.utils.ComposeFileProvider
import com.todo.todolistmobileapp.presentation.views.profile_edit.ProfileEditViewModel


@Composable
fun ProfileEditContent(
    navController: NavHostController,
    viewModel: ProfileEditViewModel = hiltViewModel()
) {
    val state = viewModel.state
    viewModel.resultingActivityHandler.handle()

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                painter = painterResource(
                    id = R.drawable.foto1
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alpha = 0.3f
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(60.dp))
                Text(text = "aquiii")
                Spacer(modifier = Modifier.height(60.dp))

                if (viewModel.imageUri != "") {
                    AsyncImage(
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        model = viewModel.imageUri,
                        contentDescription = "Seleccionar imagen"
                    )
                } else {

                    Image(
                        modifier = Modifier
                            .size(80.dp)
                            .clickable {
//                                viewModel.pickImage()
                                       viewModel.takePhoto()
                            },
                        painter = painterResource(
                            id = R.drawable.user1
                        ),
                        contentDescription = "",

                        )
                }

            }
        }
        Spacer(modifier = Modifier.height(30.dp))


        Card(
            modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 10.dp)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {

                Column(
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(5.dp)
                ) {

                    Text(
                        text = "ACTUALIZACIÓN",
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
                    modifier = Modifier.padding(top = 5.dp),
                    value = state.username,
                    onValueChange = { viewModel.onUsernameInput(it) },
                    label = "Nombre de usuario",
                    icon = Icons.Default.Person,
                    errorMsg = viewModel.usernameErrMsg,
                    validateField = { viewModel.validateUsername() }
                )




                DefaultButton(
                    text = "Actualizar datos",
                    description = "Actualizar mis datos",
                    onClick = { viewModel.onUpdate() }
                )


            }
        }


    }


}

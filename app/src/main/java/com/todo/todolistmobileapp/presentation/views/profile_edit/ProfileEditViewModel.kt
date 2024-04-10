package com.todo.todolistmobileapp.presentation.views.profile_edit

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.domain.model.User
import com.todo.todolistmobileapp.domain.use_cases.users.UsersUseCase
import com.todo.todolistmobileapp.presentation.utils.ComposeFileProvider
import com.todo.todolistmobileapp.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val usersUseCase: UsersUseCase, @ApplicationContext private val context: Context
) :
    ViewModel() {

    var state by mutableStateOf(ProfileEditState())
        private set
    var usernameErrMsg by mutableStateOf("")
        private set
    val userString = savedStateHandle.get<String>("user")
    val user = User.fromJson(userString!!)
    var updateResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    val resultingActivityHandler = ResultingActivityHandler()

    //IMAGES
    var imageUri by mutableStateOf("")

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        imageUri = result.toString()
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        imageUri = ComposeFileProvider.getPathFromBitmap(context, result!!)
    }

    init {
        state = state.copy(username = user.username)
    }

    fun onUpdate() {
        val myuser = User(
            id = user.id,
            username = state.username,
            image = ""
        )
        update(myuser)
    }

    fun update(user: User) = viewModelScope.launch {
        updateResponse = Response.Loading
        val result = usersUseCase.update(user)
        updateResponse = result
    }

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }

    fun validateUsername() {
        if (state.username.length >= 5) {
            usernameErrMsg = ""
        } else {
            usernameErrMsg = "Al menos requiere 4 caracteres"
        }
    }
}

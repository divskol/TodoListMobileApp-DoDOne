package com.todo.todolistmobileapp.presentation.views.profile_edit

import android.content.Context
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
import java.io.File
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

    //IMAGE RESPONSE
    var saveImageResponse by mutableStateOf<Response<String>?>(null)
        private set

    var file: File? = null
    fun saveImage() = viewModelScope.launch {
        if (file != null) {

            saveImageResponse = Response.Loading
            val result = usersUseCase.saveImage(file!!)
            saveImageResponse = result
        }
    }
//IMAGE RESPONSE


    val resultingActivityHandler = ResultingActivityHandler()


    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }

    }

    init {
        state = state.copy(username = user.username, image = user.image)
    }

    fun onUpdate(url: String) {
        val myuser = User(
            id = user.id,
            username = state.username,
            image = url
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

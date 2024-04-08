package com.todo.todolistmobileapp.presentation.views.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.todo.todolistmobileapp.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) :
    ViewModel() {

    var state by mutableStateOf(ProfileEditState())
        private set
    var usernameErrMsg by mutableStateOf("")
        private set
    val userString = savedStateHandle.get<String>("user")
    val user = User.fromJson(userString!!)


    init {
        state = state.copy(username = user.username)
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

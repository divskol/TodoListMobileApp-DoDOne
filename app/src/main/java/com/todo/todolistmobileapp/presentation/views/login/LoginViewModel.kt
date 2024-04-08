package com.todo.todolistmobileapp.presentation.views.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases) : ViewModel() {
    //STateForm
    var state by mutableStateOf(LoginState())
        private set


    //Email

    var isEmailValid by mutableStateOf(false)
    var emailErrMsg by mutableStateOf("")


    var isPasswordValid by mutableStateOf(false)
    var passwordlErrMsg by mutableStateOf("")

    var isEnabledLoginButton = false


    //LOGIN response
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)


    val currentUser = authUseCases.currentUser()

    init {
        if (currentUser != null) {
            loginResponse = Response.Success(currentUser)
        }
    }


    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun login() =
        viewModelScope.launch {
            loginResponse = Response.Loading
            val result = authUseCases.login(state.email, state.password)
            loginResponse = result
        }


    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            isEmailValid = true
            emailErrMsg = ""
        } else {
            isEmailValid = false
            emailErrMsg = " El email no es valido"

        }
        enabledLoginButton()
    }

    fun validatePassword() {
        if (state.password.length >= 6) {
            isPasswordValid = true
            passwordlErrMsg = ""
        } else {
            isPasswordValid = false
            passwordlErrMsg = "Al menos requiere 6 caracteres"

        }
        enabledLoginButton()
    }

    fun enabledLoginButton() {
        isEnabledLoginButton = isEmailValid && isPasswordValid
    }
}
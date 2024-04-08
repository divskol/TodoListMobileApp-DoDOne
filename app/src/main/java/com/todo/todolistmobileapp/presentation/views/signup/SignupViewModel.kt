package com.todo.todolistmobileapp.presentation.views.signup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.domain.model.User
import com.todo.todolistmobileapp.domain.use_cases.auth.AuthUseCases
import com.todo.todolistmobileapp.domain.use_cases.users.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val usersUseCase: UsersUseCase
) : ViewModel() {

    var state by mutableStateOf(SignupState())

    var isUsernameValid by mutableStateOf(false)
        private set

    var usernameErrMsg by mutableStateOf("")
        private set

    //Confirmar contraseña
    var isConfirmPasswordValid by mutableStateOf(false)
        private set
    var confirmPasswordErrMsg by mutableStateOf("")
        private set

    //Email
    var isEmailValid by mutableStateOf(false)
        private set
    var emailErrMsg by mutableStateOf("")
        private set

    var isPasswordValid by mutableStateOf(false)
        private set
    var passwordlErrMsg by mutableStateOf("")
        private set

    var isEnabledLoginButton = false


    var signupResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    var user = User();

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String) {
        state = state.copy(confirmPassword = confirmPassword)
    }


    fun onSignup() {
        user.username = state.username
        user.email = state.email
        user.password = state.password
        signup(user)
    }

    fun signup(user: User) = viewModelScope.launch {
        signupResponse = Response.Loading
        val result = authUseCases.signup(user)
        signupResponse = result
    }

    fun createUser() {
        viewModelScope.launch {
            user.id = authUseCases.currentUser()!!.uid
            usersUseCase.create(user)
        }

    }


    fun validateUsername() {
        if (state.username.length >= 5) {
            isUsernameValid = true
            usernameErrMsg = ""
        } else {
            isUsernameValid = false
            usernameErrMsg = "Al menos requiere 4 caracteres"

        }
        enabledLoginButton()
    }

    fun validateConfirmPassword() {
        if (state.password == state.confirmPassword) {
            isConfirmPasswordValid = true
            confirmPasswordErrMsg = ""
        } else {
            isConfirmPasswordValid = false
            confirmPasswordErrMsg = "Las contraseñas no coinciden"

        }
        enabledLoginButton()
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
        isEnabledLoginButton =
            isEmailValid && isPasswordValid && isUsernameValid && isConfirmPasswordValid
    }

}
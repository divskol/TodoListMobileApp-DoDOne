package com.todo.todolistmobileapp.presentation.views.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {
    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrMsg: MutableState<String> = mutableStateOf("")

    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isConfirmPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrMsg: MutableState<String> = mutableStateOf("")


    //Email
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordlErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledLoginButton = false

    fun validateUsername() {
        if (username.value.length >= 5) {
            isUsernameValid.value = true
            usernameErrMsg.value = ""
        } else {
            isUsernameValid.value = false
            usernameErrMsg.value = "Al menos requiere 4 caracteres"

        }
        enabledLoginButton()
    }

    fun validateConfirmPassword() {
        if (password.value == confirmPassword.value) {
            isConfirmPasswordValid.value = true
            confirmPasswordErrMsg.value = ""
        } else {
            isConfirmPasswordValid.value = false
            confirmPasswordErrMsg.value = "Las contraseñas no coinciden"

        }
        enabledLoginButton()
    }

    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrMsg.value = ""
        } else {
            isEmailValid.value = false
            emailErrMsg.value = " El email no es valido"

        }
        enabledLoginButton()
    }

    fun validatePassword() {
        if (password.value.length >= 6) {
            isPasswordValid.value = true
            passwordlErrMsg.value = ""
        } else {
            isPasswordValid.value = false
            passwordlErrMsg.value = "Al menos requiere 6 caracteres"

        }
        enabledLoginButton()
    }

    fun enabledLoginButton() {
        isEnabledLoginButton =
            isEmailValid.value && isPasswordValid.value && isUsernameValid.value && isConfirmPasswordValid.value
    }

}
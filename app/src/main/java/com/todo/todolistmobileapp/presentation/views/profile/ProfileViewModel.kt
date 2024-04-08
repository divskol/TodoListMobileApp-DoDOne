package com.todo.todolistmobileapp.presentation.views.profile

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.todo.todolistmobileapp.domain.model.User
import com.todo.todolistmobileapp.domain.use_cases.auth.AuthUseCases
import com.todo.todolistmobileapp.domain.use_cases.users.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCase: UsersUseCase
) : ViewModel() {
    var userData by mutableStateOf(User())
        private set

    val currentUser = authUseCases.currentUser()


    init {
        getUserById()
    }
    private fun getUserById() =
        viewModelScope.launch {
            userUseCase.getUserById(currentUser!!.uid).collect() { data ->
                userData = data
            }
        }

    fun logout() {
        authUseCases.logout()
    }
}
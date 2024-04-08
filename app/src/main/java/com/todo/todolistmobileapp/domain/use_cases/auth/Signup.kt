package com.todo.todolistmobileapp.domain.use_cases.auth

import com.todo.todolistmobileapp.domain.model.User
import com.todo.todolistmobileapp.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.signUp(user)
}
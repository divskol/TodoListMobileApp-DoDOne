package com.todo.todolistmobileapp.domain.use_cases.auth

import com.todo.todolistmobileapp.domain.repository.AuthRepository
import javax.inject.Inject

class Logout @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.logout()
}
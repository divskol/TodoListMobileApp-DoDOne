package com.todo.todolistmobileapp.domain.use_cases.auth

import com.todo.todolistmobileapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.currentUser
}
package com.todo.todolistmobileapp.domain.repository

import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.domain.model.User

interface UsersRepository {
    suspend fun create(user: User): Response<Boolean>
}
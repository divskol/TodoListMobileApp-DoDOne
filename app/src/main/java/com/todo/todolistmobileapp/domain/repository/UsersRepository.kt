package com.todo.todolistmobileapp.domain.repository

import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.domain.model.User
import java.io.File
import java.util.concurrent.Flow

interface UsersRepository {
    suspend fun create(user: User): Response<Boolean>

    suspend fun update(user:User): Response<Boolean>
    suspend fun  saveImage(file:File):Response<String>
    fun getUserById(id: String): kotlinx.coroutines.flow.Flow<User>
}
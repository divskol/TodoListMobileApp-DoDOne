package com.todo.todolistmobileapp.data.repository

import com.google.firebase.firestore.CollectionReference
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.domain.model.User
import com.todo.todolistmobileapp.domain.repository.UsersRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(private val usersRef: CollectionReference) :
    UsersRepository {
    override suspend fun create(user: User): Response<Boolean> {
        return try {
            user.password = ""
            usersRef.document(user.id).set(user).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}
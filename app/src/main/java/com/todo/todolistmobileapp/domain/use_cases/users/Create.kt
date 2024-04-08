package com.todo.todolistmobileapp.domain.use_cases.users

import com.todo.todolistmobileapp.domain.model.User
import com.todo.todolistmobileapp.domain.repository.UsersRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: UsersRepository) {
    suspend operator fun invoke(user: User) = repository.create(user)
}
package com.todo.todolistmobileapp.domain.use_cases.users

import com.todo.todolistmobileapp.domain.model.User
import com.todo.todolistmobileapp.domain.repository.UsersRepository
import javax.inject.Inject

class Update @Inject constructor(private val repository: UsersRepository) {
    //operator para usar invoke
    suspend operator fun invoke(user: User) = repository.update(user)
}
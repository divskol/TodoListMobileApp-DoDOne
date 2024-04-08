package com.todo.todolistmobileapp.domain.use_cases.users

import com.todo.todolistmobileapp.domain.repository.UsersRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UsersRepository) {
    operator fun invoke(id: String) = repository.getUserById(id)
}
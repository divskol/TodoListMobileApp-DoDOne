package com.todo.todolistmobileapp.domain.use_cases.users

data class UsersUseCase(
    val create: Create,
    val getUserById: GetUserById,
    val update: Update,
    val saveImage: SaveImage
)

package com.todo.todolistmobileapp.domain.use_cases.auth

data class AuthUseCases(
    val currentUser: GetCurrentUser,
    val login: Login,
    val logout: Logout,
    val signup: Signup
)
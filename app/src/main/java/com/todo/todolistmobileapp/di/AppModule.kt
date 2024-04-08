package com.todo.todolistmobileapp.di

import com.google.firebase.auth.FirebaseAuth
import com.todo.todolistmobileapp.data.repository.AuthRepositoryImpl
import com.todo.todolistmobileapp.domain.repository.AuthRepository
import com.todo.todolistmobileapp.domain.use_cases.auth.AuthUseCases
import com.todo.todolistmobileapp.domain.use_cases.auth.GetCurrentUser
import com.todo.todolistmobileapp.domain.use_cases.auth.Login
import com.todo.todolistmobileapp.domain.use_cases.auth.Logout
import com.todo.todolistmobileapp.domain.use_cases.auth.Signup
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository) =
        AuthUseCases(
            currentUser = GetCurrentUser(repository),
            login = Login(repository),
            logout = Logout(repository),
            signup = Signup(repository)
        )

}
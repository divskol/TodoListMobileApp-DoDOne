package com.todo.todolistmobileapp.di

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
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
import com.todo.todolistmobileapp.core.Constants.USERS
import com.todo.todolistmobileapp.data.repository.UsersRepositoryImpl
import com.todo.todolistmobileapp.domain.repository.UsersRepository
import com.todo.todolistmobileapp.domain.use_cases.users.Create
import com.todo.todolistmobileapp.domain.use_cases.users.UsersUseCase

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UsersRepositoryImpl): UsersRepository = impl


    @Provides
    fun provideAuthUseCases(repository: AuthRepository) =
        AuthUseCases(
            currentUser = GetCurrentUser(repository),
            login = Login(repository),
            logout = Logout(repository),
            signup = Signup(repository)
        )

    @Provides
    fun provideUsersUseCases(repository: UsersRepository) =
        UsersUseCase(create = Create(repository))
}
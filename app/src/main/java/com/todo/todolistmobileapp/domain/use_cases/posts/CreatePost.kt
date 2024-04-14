package com.todo.todolistmobileapp.domain.use_cases.posts

import com.todo.todolistmobileapp.domain.model.Post
import com.todo.todolistmobileapp.domain.repository.PostsRepository
import java.io.File
import javax.inject.Inject

class CreatePost @Inject constructor(private val repository: PostsRepository){

    suspend operator fun invoke(post: Post, file: File) = repository.create(post, file)

}
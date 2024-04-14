package com.todo.todolistmobileapp.domain.use_cases.posts

import com.todo.todolistmobileapp.domain.repository.PostsRepository
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: PostsRepository) {

    operator fun invoke() = repository.getPosts()

}
package com.todo.todolistmobileapp.presentation.views.new_post

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.domain.model.Post
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.domain.use_cases.auth.AuthUseCases
import com.todo.todolistmobileapp.domain.use_cases.posts.PostsUseCases
import com.todo.todolistmobileapp.presentation.utils.ComposeFileProvider
import com.todo.todolistmobileapp.presentation.utils.ResultingActivityHandler
import com.todo.todolistmobileapp.presentation.views.new_post.NewPostState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class NewPostViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val postsUseCases: PostsUseCases,
    private val authUseCases: AuthUseCases,
): ViewModel() {

    var state by mutableStateOf(NewPostState())

    // FILE
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    // RESPONSE
    var createPostResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    //USER SESSION
    val currentUser = authUseCases.currentUser()

    val radioOptions = listOf(
        CategoryRadioButton("Personal", R.drawable.cat_personal),
        CategoryRadioButton("Estudio", R.drawable.cat_estudio),
        CategoryRadioButton("Trabajo", R.drawable.cat_trabajo),
        CategoryRadioButton("Viaje", R.drawable.cat_viaje),
        CategoryRadioButton("Investigación", R.drawable.cat_investigacion),
    )

    fun createPost(post: Post) = viewModelScope.launch {
        createPostResponse = Response.Loading
        val result = postsUseCases.create(post, file!!)
        createPostResponse = result
    }

    fun onNewPost() {
        val post = Post(
            name = state.name,
            description = state.description,
            category = state.category,
            idUser = currentUser?.uid ?: ""
        )
        createPost(post)
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }

    fun clearForm() {
        state = state.copy(
            name ="",
            category = "",
            description = "",
            image = ""
        )
        createPostResponse = null
    }

    fun onNameInput(name: String) {
        state = state.copy(name = name)
    }

    fun onCategoryInput(category: String) {
        state = state.copy(category = category)
    }

    fun onDescriptionInput(description: String) {
        state = state.copy(description = description)
    }

    fun onImageInput(image: String) {
        state = state.copy(image = image)
    }

}

data class CategoryRadioButton(
    var category: String,
    var image: Int
)
package com.todo.todolistmobileapp.presentation.views.update_post

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.todo.todolistmobileapp.presentation.views.update_post.UpdatePostState
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.domain.model.Post
import com.todo.todolistmobileapp.domain.model.Response
import com.todo.todolistmobileapp.domain.use_cases.auth.AuthUseCases
import com.todo.todolistmobileapp.domain.use_cases.posts.PostsUseCases
import com.todo.todolistmobileapp.presentation.utils.ComposeFileProvider
import com.todo.todolistmobileapp.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class UpdatePostViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val savedStateHandle: SavedStateHandle,
    private val postsUseCases: PostsUseCases,
    private val authUseCases: AuthUseCases,
): ViewModel() {

    var state by mutableStateOf(UpdatePostState())

    // FILE
    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    // ARGUMENTS
    val data = savedStateHandle.get<String>("post")
    val post = Post.fromJson(data!!)

    // RESPONSE
    var updatePostResponse by mutableStateOf<Response<Boolean>?>(null)
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

    init {
        state = state.copy(
            name = post.name,
            description = post.description,
            image = post.image,
            category = post.category,
        )
    }

    fun updatePost(post: Post) = viewModelScope.launch {
        updatePostResponse = Response.Loading
        val result = postsUseCases.updatePost(post, file)
        updatePostResponse = result
    }

    fun onUpdatePost() {
        val post = Post(
            id = post.id,
            name = state.name,
            description = state.description,
            category = state.category,
            image = post.image,
            idUser = currentUser?.uid ?: ""
        )
        updatePost(post)
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
//        state = state.copy(
//            name ="",
//            category = "",
//            description = "",
//            image = ""
//        )
        updatePostResponse = null
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
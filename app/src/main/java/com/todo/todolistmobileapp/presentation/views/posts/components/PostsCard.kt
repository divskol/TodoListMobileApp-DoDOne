package com.todo.todolistmobileapp.presentation.views.posts.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.todo.todolistmobileapp.domain.model.Post
import com.todo.todolistmobileapp.R
import com.todo.todolistmobileapp.presentation.navigation.DetailsScreen
import com.todo.todolistmobileapp.presentation.views.posts.PostsViewModel

@Composable
fun PostsCard(
    navController: NavHostController,
    post: Post,
    viewModel: PostsViewModel = hiltViewModel()
) {

    Card(
        modifier = Modifier
            .padding(top = 0.dp, bottom = 15.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = DetailsScreen.DetailPost.passPost(post.toJson()))
            },
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        contentColor = Color.DarkGray,
        backgroundColor = Color.LightGray,

        ) {
        Row() {
            AsyncImage(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .padding(5.dp)
                    .clip(CircleShape),
                model = post.image,

                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Column {


                Text(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                    text = post.name,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 3.dp),
                    text = post.user?.username ?: "",
                    fontSize = 12.sp
                )
                Text(
                    modifier = Modifier.padding(
                        start = 15.dp,
                        end = 15.dp,
                        top = 3.dp,
                        bottom = 10.dp
                    ),
                    text = post.description,
                    fontSize = 13.sp,
                    maxLines = 2,
                    color = Color.Gray
                )
            }

            Column(
                modifier = Modifier.padding(start = 75.dp, top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (post.likes.contains(viewModel.currentUser?.uid)) {
                    Image(
                        modifier = Modifier
                            .size(23.dp)
                            .clickable {
                                viewModel.deleteLike(post.id, viewModel.currentUser?.uid ?: "")
                            },
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = ""
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(23.dp)
                            .clickable {
                                viewModel.like(post.id, viewModel.currentUser?.uid ?: "")
                            },
                        painter = painterResource(id = R.drawable.like_outline),
                        contentDescription = ""
                    )
                }
//
//                Text(
//                    modifier = Modifier.padding(start = 5.dp),
//                    text = post.likes.size.toString(),
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 17.sp
//                )
            }
        }
    }

}
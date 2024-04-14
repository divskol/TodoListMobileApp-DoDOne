package com.todo.todolistmobileapp.presentation.views.my_posts.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.todo.todolistmobileapp.domain.model.Post
import com.todo.todolistmobileapp.presentation.navigation.DetailsScreen
import com.todo.todolistmobileapp.presentation.views.my_posts.MyPostsViewModel

@Composable
fun MyPostsCard(navController: NavHostController, post: Post, viewModel: MyPostsViewModel = hiltViewModel()) {

    Card(
        modifier = Modifier
            .padding(top = 0.dp, bottom = 15.dp)
            .clickable {
                navController.navigate(route = DetailsScreen.DetailPost.passPost(post.toJson()))
            },
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp),
        contentColor = Color.Black,
        backgroundColor = Color.LightGray
        ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
            Text(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                text = post.name,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 3.dp),
                text = post.description,
                fontSize = 13.sp,
                maxLines = 2,
                color = Color.Gray
            )
            Row(
                modifier = Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(route = DetailsScreen.UpdatePost.passPost(post.toJson()))
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.Edit,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { viewModel.delete(post.id) }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }

        }
    }

}
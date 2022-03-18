package me.bilalhaider.moviedatabase.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import me.bilalhaider.moviedatabase.network.model.Movie

/**
 * Created by Bilal Haider on 17/03/2022
 */
@Composable
fun Movie(
    movieViewModel: MovieViewModel = viewModel()
) {
    movieViewModel.movie.collectAsState().value?.let { movie ->
        LazyColumn {
            item {
                MovieView(movie = movie)
            }
        }
    }
}

@Composable
fun MovieView(
    movie: Movie
) {
    Row() {
        Column() {
            Text(text = movie.title)
            Text(text = movie.genre)
            Text(text = movie.rated)
        }

        Box(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .clip(RoundedCornerShape(4.dp))
        ) {
            Image(
                painter = rememberImagePainter(
                    data = movie.poster),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .width(88.dp)
            )
        }
    }
}

@Preview
@Composable
fun MoviePreview() {
    MaterialTheme { }
}
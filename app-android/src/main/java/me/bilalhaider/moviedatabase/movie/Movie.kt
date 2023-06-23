package me.bilalhaider.moviedatabase.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import me.bilalhaider.moviedatabase.network.model.Movie
import me.bilalhaider.moviedatabase.network.model.sampleMovieObject

/**
 * Created by Bilal Haider on 17/03/2022
 */
@Composable
fun Movie() {
    val movieViewModel: MovieViewModel = viewModel()

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
    Column {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
        ) {
            Image(
                painter = rememberImagePainter(
                    data = movie.poster),
                contentDescription = "Poster of ${movie.title}",
                contentScale = ContentScale.FillWidth ,
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.radialGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            radius = 500f
                        )
                    )
            )

            Text(
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(all = 20.dp),
                text = "${movie.title} (${movie.year})"
            )
        }

        Column(Modifier.padding(all = 20.dp)) {
            Text(
                color = Color.White,
                text = movie.plot
            )

            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            Text(
                color = Color.White,
                text = "Rated: ${movie.rated}"
            )

            Text(
                color = Color.White,
                text = "Length: ${movie.runtime}"
            )

            Text(
                color = Color.White,
                text = "Director: ${movie.director}"
            )

            Text(
                color = Color.White,
                text = "Writers: ${movie.writer}"
            )

            Text(
                color = Color.White,
                text = "Starring: ${movie.actors}"
            )

            Text(
                color = Color.White,
                text = "Awards: ${movie.awards}"
            )
        }
    }
}

@Preview
@Composable
fun MoviePreview() {
    MaterialTheme {
        MovieView(movie = sampleMovieObject)
    }
}
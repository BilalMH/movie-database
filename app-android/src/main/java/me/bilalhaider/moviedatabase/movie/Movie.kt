package me.bilalhaider.moviedatabase.movie

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Created by Bilal Haider on 17/03/2022
 */
@Composable
fun Movie(
    movieViewModel: MovieViewModel = viewModel()
) {
    movieViewModel.movie.collectAsState().value?.let { movie ->
        Column {
            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.statusBars))

            LazyColumn {
                item {
                    Text(
                        text = movie.title
                    )
                }
            }
        }
    }
}
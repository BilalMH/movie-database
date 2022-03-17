package me.bilalhaider.moviedatabase.movie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import me.bilalhaider.moviedatabase.network.mobileapi.MovieRepository
import me.bilalhaider.moviedatabase.network.model.Movie
import javax.inject.Inject

/**
 * Created by Bilal Haider on 17/03/2022
 */
@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val movie: StateFlow<Movie?> = movieRepository.data

    fun fetchMovie(movieId: String) {
        viewModelScope.launch {
            try {
                movieRepository.getMovie(movieId)
            } catch (e: Throwable) {
                Log.e("MovieViewModel -> fetMovie()", e.localizedMessage ?: "")
            }
        }
    }

}
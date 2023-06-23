package me.bilalhaider.moviedatabase.movie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by Bilal Haider on 17/03/2022
 */
@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE_ID = "movie_id"

        fun start(
            context: Context,
            movieID: String
        ) {
            context.startActivity(
                with(Intent(context, MovieActivity::class.java)) {
                    putExtra(EXTRA_MOVIE_ID, movieID)
                }
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.getStringExtra(EXTRA_MOVIE_ID)?.let {
            createUI(it)
        } ?: finish()
    }

    private fun createUI(movieId: String) {
        lifecycleScope.launch {
            setContent {

                viewModel<MovieViewModel>().apply {
                    fetchMovie(movieId)
                }

                MaterialTheme {
                    Movie()
                }

            }
        }

    }

}
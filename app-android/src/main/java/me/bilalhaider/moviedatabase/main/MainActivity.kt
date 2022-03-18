package me.bilalhaider.moviedatabase.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import dagger.hilt.android.AndroidEntryPoint
import me.bilalhaider.moviedatabase.movie.MovieActivity

/**
 * Created by Bilal Haider on 18/03/2022
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Search {
                    MovieActivity.start(this, it)
                }
            }
        }
    }

}


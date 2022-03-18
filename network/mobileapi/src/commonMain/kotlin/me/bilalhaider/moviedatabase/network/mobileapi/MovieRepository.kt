package me.bilalhaider.moviedatabase.network.mobileapi

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.bilalhaider.moviedatabase.network.mobileapi.client.MobileAPIClient
import me.bilalhaider.moviedatabase.network.mobileapi.client.endpoint.movie
import me.bilalhaider.moviedatabase.network.mobileapi.client.use
import me.bilalhaider.moviedatabase.network.model.Movie

/**
 * Created by Bilal Haider on 17/03/2022
 */
class MovieRepository(
    private val mobileAPIClient: MobileAPIClient
) {

    private val _data = MutableStateFlow<Movie?>(null)
    val data: StateFlow<Movie?> = _data

    suspend fun getMovie(id: String) {
        mobileAPIClient.use {
            it.movie(id)
        }?.let {
             _data.value = it
        }
    }

}
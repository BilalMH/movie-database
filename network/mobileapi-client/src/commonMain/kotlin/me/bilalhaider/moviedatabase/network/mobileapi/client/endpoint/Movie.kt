package me.bilalhaider.moviedatabase.network.mobileapi.client.endpoint

import me.bilalhaider.moviedatabase.network.mobileapi.client.MobileAPIClient
import me.bilalhaider.moviedatabase.network.model.Movie

/**
 * Created by Bilal Haider on 17/03/2022
 */
suspend fun MobileAPIClient.movie(
    id: String
): Movie? = executeGET<Movie> {
    url {
        encodedPath = "/?apikey=36fa806b&i=$id"
    }
}
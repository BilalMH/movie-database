package me.bilalhaider.moviedatabase.network.mobileapi.client.endpoint

import io.ktor.http.encodedPath
import me.bilalhaider.moviedatabase.network.mobileapi.client.MobileAPIClient
import me.bilalhaider.moviedatabase.network.mobileapi.client.response.SearchResponse

/**
 * Created by Bilal Haider on 17/03/2022
 */
suspend fun MobileAPIClient.search(
    query: String
): SearchResponse? = executeGET<SearchResponse> {
    url {
        encodedPath = "/?apikey=36fa806b&s=$query"
    }
}
package me.bilalhaider.moviedatabase.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Bilal Haider on 17/03/2022
 */
@Serializable
data class SearchResult(
    @SerialName("Title") val title: String,
    @SerialName("Year") val year: String,
    val imdbId: String,
    @SerialName("Poster") val poster: String,
)
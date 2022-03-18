package me.bilalhaider.moviedatabase.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Bilal Haider on 17/03/2022
 */
@Serializable
data class Movie(
    @SerialName("Title") val title: String,
    @SerialName("Year") val year: String,
    @SerialName("Rated") val rated: String,
    @SerialName("Released") val theatricalRelease: String,
    @SerialName("DVD") val dvdRelease: String,
    @SerialName("Runtime") val runtime: String,
    @SerialName("Genre") val genre: String,
    @SerialName("Director") val director: String,
    @SerialName("Writer") val writer: String,
    @SerialName("Actors") val actors: String,
    @SerialName("Plot") val plot: String,
    @SerialName("Awards") val awards: String,
    @SerialName("Poster") val poster: String,
    @SerialName("Ratings") val ratings: List<Rating> = emptyList(),
    val imdbID: String
)
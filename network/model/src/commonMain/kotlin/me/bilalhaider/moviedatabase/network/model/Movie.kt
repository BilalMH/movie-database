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

val sampleMovieObject = Movie (
    title = "The Batman",
    year = "2022",
    rated = "R",
    theatricalRelease = "04 Mar 2022",
    dvdRelease = "19 Apr 2022",
    runtime = "176 min",
    genre = "Action, Crime, Drama",
    director = "Matt Reeves",
    writer = "Matt Reeves, Peter Craig, Bob Kane",
    actors = "Robert Pattinson, Zoë Kravitz, Jeffrey Wright",
    plot = "When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
    awards = "Nominated for 3 Oscars. 33 wins & 163 nominations total",
    poster = "https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_SX300.jpg",
    ratings = emptyList(),
    imdbID = "1"
)
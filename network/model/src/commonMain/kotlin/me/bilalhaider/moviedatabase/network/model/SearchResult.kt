package me.bilalhaider.moviedatabase.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Locale

/**
 * Created by Bilal Haider on 17/03/2022
 */
@Serializable
data class SearchResult(
    @SerialName("Title") val title: String,
    @SerialName("Year") val year: String,
    @SerialName("Type") val type: String,
    val imdbID: String,
    @SerialName("Poster") val poster: String,
) {

    fun searchResultSubTitle(): String = "$year · ${type.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}"

}
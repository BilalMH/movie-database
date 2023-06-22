package me.bilalhaider.moviedatabase.network.mobileapi.client.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.bilalhaider.moviedatabase.network.model.SearchResult

/**
 * Created by Bilal Haider on 17/03/2022
 */
@Serializable
data class SearchResponse(
    @SerialName("Search") val data: List<SearchResult> = emptyList(),
    val totalResults: String = ""
)
package me.bilalhaider.moviedatabase.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Bilal Haider on 17/03/2022
 */
@Serializable
data class Rating(
    @SerialName("Source") val ratingSource: String,
    @SerialName("Value") val rating: String
)
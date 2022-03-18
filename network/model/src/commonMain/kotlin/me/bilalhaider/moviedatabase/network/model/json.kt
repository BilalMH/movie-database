package me.bilalhaider.moviedatabase.network.model

import kotlinx.serialization.json.Json

/**
 * Created by Bilal Haider on 18/03/2022
 */
fun json(): Json = Json {
    ignoreUnknownKeys = true
    isLenient = true
}
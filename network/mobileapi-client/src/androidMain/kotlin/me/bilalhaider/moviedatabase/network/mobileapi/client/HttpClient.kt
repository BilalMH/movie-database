package me.bilalhaider.moviedatabase.network.mobileapi.client

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*

/**
 * Created by Bilal Haider on 17/03/2022
 */
actual fun createHttpClient(): HttpClient = HttpClient(OkHttp)
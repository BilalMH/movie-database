package me.bilalhaider.moviedatabase.network.mobileapi.client

import io.ktor.client.*
import io.ktor.client.engine.HttpClientEngine

/**
 * Created by Bilal Haider on 17/03/2022
 */
expect fun createHttpClient(engine: HttpClientEngine): HttpClientEngine
package me.bilalhaider.moviedatabase.network.mobileapi.client

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

/**
 * Created by Bilal Haider on 17/03/2022
 */
actual fun createHttpClient(engine: HttpClientEngine): HttpClientEngine = OkHttp.create()
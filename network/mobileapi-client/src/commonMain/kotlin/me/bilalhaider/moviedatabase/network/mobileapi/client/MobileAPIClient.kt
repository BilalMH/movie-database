package me.bilalhaider.moviedatabase.network.mobileapi.client

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.http.Url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

/**
 * Created by Bilal Haider on 17/03/2022
 */
open class MobileAPIClient(private val httpEngine: HttpClientEngine = OkHttp.create()) : Closeable {

    override fun close() {
        _httpClient?.close()
        _httpClient = null
    }

    private var _httpClient: HttpClient? = null

    internal val client: HttpClient
        get() {
            if (_httpClient == null) {
                _httpClient = HttpClient(httpEngine) {

                    install(HttpTimeout) {
                        requestTimeoutMillis = 5000
                        connectTimeoutMillis = 5000
                        socketTimeoutMillis = 5000
                    }

                    install(ContentNegotiation) {
                        json(
                            Json {
                                ignoreUnknownKeys = true
                                prettyPrint = true
                                isLenient = true
                            }
                        )
                    }

                    defaultRequest {
                        val baseUrl = Url("http://www.omdbapi.com")

                        host = baseUrl.host
                        url {
                            protocol = baseUrl.protocol
                        }
                    }
                }
            }

            return _httpClient as HttpClient
        }

    internal suspend inline fun <reified T> executeGET(
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): T? = withContext(Dispatchers.Default) {
        client.get(block = block).body()
    }
}
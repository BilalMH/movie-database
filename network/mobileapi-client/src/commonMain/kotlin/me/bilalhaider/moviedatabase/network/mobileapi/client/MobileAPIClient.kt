package me.bilalhaider.moviedatabase.network.mobileapi.client

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.compression.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Bilal Haider on 17/03/2022
 */
open class MobileAPIClient(): Closeable {

    override fun close() {
        _httpClient?.close()
        _httpClient = null
    }

    private var _httpClient: HttpClient? = null

    internal val client: HttpClient
        get() {
            if (_httpClient == null) {
                _httpClient = with(createHttpClient()) {
                    config {

                        ContentEncoding {  }

                        install(HttpTimeout) {
                            requestTimeoutMillis = 5000
                            connectTimeoutMillis = 5000
                            socketTimeoutMillis = 5000
                        }

                        Json {
                            serializer = KotlinxSerializer()
                        }

                        HttpResponseValidator {
                            //TODO - Handle Responses for exceptions
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
            }

            return _httpClient as HttpClient
        }

    internal suspend inline fun <reified T> executeGET(
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): T? = withContext(Dispatchers.Default) {
        client.get<T>(block = block)
    }
}
package com.draja.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

@PublishedApi
internal object KtorClient {

    private var ktorClient: HttpClient? = null

    fun buildKtorClient(): HttpClient = ktorClient ?: initKtorClient()

    private fun initKtorClient(): HttpClient {
        val httpClient = HttpClient(OkHttp) {

            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTP
                }
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
            expectSuccess = true
        }
        ktorClient = httpClient
        return httpClient
    }

    internal fun destroyClient() {
        ktorClient = null
    }
}
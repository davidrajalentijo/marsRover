package com.draja.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod

const val BASE_URL = "http://192.168.0.23:8080/"

class NetworkService {

    companion object {
        @Volatile
        private var instance: NetworkService? = null

        fun getInstance() = instance

        fun createInstance() {
            instance ?: synchronized(this) {
                instance ?: NetworkService().also {
                    instance = it
                }
            }
        }

        internal fun destroy() {
            instance = null
        }
    }

    suspend inline fun <reified T> createApi(
        url: String,
        httMethod: HttMethodRequest,
        body: Any? = null
    ): Result<T> = resultApiCall {
        getHttpClient().request(BASE_URL + url) {
            method = getHttpMethod(httMethod)
            body?.let {
                setBody(it)
            }
        }.body<T>()
    }


    @PublishedApi
    internal inline fun <T> resultApiCall(apiCall: () -> T): Result<T> =
        try {
            Result.success(apiCall())
        } catch (e: ResponseException) {
            Result.failure(e)
        } catch (e: Throwable) {
            Result.failure(e)
        }

    @PublishedApi
    internal fun getHttpMethod(moduleMethod: HttMethodRequest): HttpMethod =
        when (moduleMethod) {
            HttMethodRequest.GET -> {
                HttpMethod.Get
            }

            HttMethodRequest.POST -> {
                HttpMethod.Post
            }

            HttMethodRequest.PUT -> {
                HttpMethod.Put
            }

            HttMethodRequest.PATCH -> {
                HttpMethod.Patch
            }

            HttMethodRequest.DELETE -> {
                HttpMethod.Delete
            }
        }

    @PublishedApi
    internal fun getHttpClient(): HttpClient =
        KtorClient.buildKtorClient()
}
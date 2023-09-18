package com.example.network

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.userAgent
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class CatsApiOkHttpClientFactory() : OkHttpClientFactory {

    override fun create(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10000, TimeUnit.SECONDS)
            .readTimeout(10000, TimeUnit.SECONDS)
            .addInterceptor(getLoggingInterceptor())
            .build()
    }

    private fun getLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
        level = HttpLoggingInterceptor.Level.HEADERS

    }

    private fun Request.addUserContentToHeader(): Request {
        userAgent
        return newBuilder()
            .header("Authorization", "Client-ID 1ceddedc03a5d71")
            .method(this.method, this.body)
            .build()
    }
}

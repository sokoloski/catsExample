package com.example.network

import okhttp3.OkHttpClient

interface OkHttpClientFactory {
    fun create(): OkHttpClient
}

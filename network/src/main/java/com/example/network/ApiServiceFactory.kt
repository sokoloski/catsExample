package com.example.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiServiceFactory(okHttpClient: OkHttpClientFactory, apiUrl: ApiUrl) : ServiceFactory {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(apiUrl.get())
        .client(okHttpClient.create())
        .build()

    override fun <T> create(service: Class<T>): T = retrofit.create(service)
}

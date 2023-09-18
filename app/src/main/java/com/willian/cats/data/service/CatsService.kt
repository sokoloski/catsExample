package com.willian.cats.data.service

import com.willian.cats.data.entity.CatsRemote
import retrofit2.http.GET

interface CatsService {
    @GET("search/?q=cats")
    suspend fun getCards(): CatsRemote
}

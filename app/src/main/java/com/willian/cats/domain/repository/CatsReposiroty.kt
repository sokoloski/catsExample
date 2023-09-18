package com.willian.cats.domain.repository

interface CatsRepository {
    suspend fun getCats(): List<String>
}

package com.willian.cats.data.repository

import com.willian.cats.data.service.CatsService
import com.willian.cats.domain.repository.CatsRepository

class CatsRepositoryImpl(
    private val CatsService: CatsService
) : CatsRepository {
    override suspend fun getCats(): List<String> {
        return CatsService.getCards().getCats()
    }
}

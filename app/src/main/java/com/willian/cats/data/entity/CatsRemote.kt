package com.willian.cats.data.entity

import com.squareup.moshi.Json

data class CatsRemote (
    @field:Json(name = "data") val data: List<CatRemote>
) {
    fun getCats(): List<String> = data
        .flatMap { it.images }
        .filter { it.type == "image/jpeg" || it.type == "image/png" }
        .map { it.link }
}
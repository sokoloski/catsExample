package com.willian.cats.data.entity

import com.squareup.moshi.Json

data class ImagesRemote (
    @field:Json(name = "type") val type: String,
    @field:Json(name = "link") val link: String
) {
}
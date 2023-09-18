package com.willian.cats.data.entity

import com.squareup.moshi.Json

data class CatRemote (
    @field:Json(name = "images") val images: List<ImagesRemote>
) {

}
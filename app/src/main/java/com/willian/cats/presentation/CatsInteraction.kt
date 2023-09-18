package com.willian.cats.presentation

sealed class CatsInteraction {
    object Open : CatsInteraction()
    data class SearchCard(val search: String) : CatsInteraction()
}

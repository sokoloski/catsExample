package com.willian.cats.presentation

data class CatsState(
    val loading: Boolean = false,
    val listOfCats: List<String> = listOf(),
    val openNewCard: Boolean = false
)

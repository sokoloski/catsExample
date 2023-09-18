package com.example.network

interface ApiUrl {
    fun get(): String
    fun set(url: String)
}

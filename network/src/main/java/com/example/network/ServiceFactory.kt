package com.example.network

interface ServiceFactory {
    fun <T> create(service: Class<T>): T
}

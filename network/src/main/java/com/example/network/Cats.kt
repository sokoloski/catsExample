package com.example.network

class CatsApiUrl : ApiUrl {
    override fun get() = "https://api.imgur.com/3/gallery/"

    override fun set(url: String) {}
}

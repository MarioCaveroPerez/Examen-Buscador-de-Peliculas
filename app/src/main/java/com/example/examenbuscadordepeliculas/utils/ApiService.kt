package com.example.examenbuscadordepeliculas.utils

import okhttp3.OkHttpClient
import okhttp3.Request


object ApiService {
    private const val API_KEY = "5a032e38"
    private const val BASE_URL = "https://www.omdbapi.com/"

    private val client = OkHttpClient()

    fun searchMovies(query: String): String? {
        val url = "$BASE_URL?apikey=$API_KEY&s=$query"
        val request = Request.Builder().url(url).build()
        client.newCall(request).execute().use { response ->
            return if (response.isSuccessful) response.body?.string() else null
        }
    }

    fun getMovieDetail(imdbID: String): String? {
        val url = "$BASE_URL?apikey=$API_KEY&i=$imdbID&plot=full"
        val request = Request.Builder().url(url).build()
        client.newCall(request).execute().use { response ->
            return if (response.isSuccessful) response.body?.string() else null
        }
    }
}
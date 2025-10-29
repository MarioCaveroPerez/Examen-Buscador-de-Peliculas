package com.example.examenbuscadordepeliculas.data

data class Movie(
    val Title: String,
    val Year: String,
    val imdbID: String,
    val Poster: String
)

data class MovieResponse(
    val Search: List<Movie>?,
    val totalResults: String?,
    val Response: String
)
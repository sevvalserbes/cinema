package com.ss.cinema.domain.model

data class Movie(
    val originalTitle: String,
    val posterPath: String,
    val genreIds: List<Int>,
    val voteAverage: Number,
    val releaseDate: String
)
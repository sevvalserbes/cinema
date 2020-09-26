package com.ss.cinema.domain.model

data class Movie(
    val id: Int,
    val originalTitle: String,
    val posterPath: String,
    val voteAverage: Number,
    val releaseDate: String
)
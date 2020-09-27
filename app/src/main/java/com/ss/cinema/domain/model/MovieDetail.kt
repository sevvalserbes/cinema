package com.ss.cinema.domain.model

data class MovieDetail(
    val originalTitle: String,
    val overview: String,
    val voteAverage: Number,
    val voteCount: Int,
    val releaseDate: String,
    val runtime: Int,
    val posterPath: String,
)
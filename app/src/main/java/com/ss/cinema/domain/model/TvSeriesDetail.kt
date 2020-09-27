package com.ss.cinema.domain.model

data class TvSeriesDetail(
    val originalName: String,
    val overview: String,
    val voteAverage: Number,
    val voteCount: Int,
    val posterPath: String,
)
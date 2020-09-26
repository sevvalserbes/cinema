package com.ss.cinema.domain.model

data class MultiSearch(
    val id: Int,
    val mediaType: String,
    val posterPath: String,
    val profilePath: String,
    val originalTitle: String,
    val originalName: String,
    val name: String,
)
package com.ss.cinema.domain.model

import com.ss.cinema.util.MediaType

data class MultiSearch(
    val id: Int,
    val mediaType: MediaType,
    val posterPath: String,
    val profilePath: String,
    val originalTitle: String,
    val originalName: String,
    val name: String,
)
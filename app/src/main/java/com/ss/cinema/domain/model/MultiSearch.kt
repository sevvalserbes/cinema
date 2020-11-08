package com.ss.cinema.domain.model

import com.ss.cinema.util.mediatype.MediaType

data class MultiSearch(
    val id: Int,
    var mediaType: MediaType,
    val posterPath: String,
    val profilePath: String,
    val originalTitle: String,
    val originalName: String,
    val name: String,
)
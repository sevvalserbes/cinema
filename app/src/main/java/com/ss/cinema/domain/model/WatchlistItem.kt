package com.ss.cinema.domain.model

import com.ss.cinema.util.mediatype.MediaType

data class WatchlistItem(
    val name: String,
    val mediaType: MediaType
)
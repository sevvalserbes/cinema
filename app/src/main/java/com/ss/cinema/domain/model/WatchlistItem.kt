package com.ss.cinema.domain.model

import com.ss.cinema.util.mediatype.MediaType
import java.util.*

data class WatchlistItem(
    val id: String,
    val name: String,
    val mediaType: MediaType,
    val addedDate: Date? = null
)
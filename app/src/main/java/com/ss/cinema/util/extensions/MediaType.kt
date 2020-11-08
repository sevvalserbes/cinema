package com.ss.cinema.util.extensions

import com.ss.cinema.R
import com.ss.cinema.util.mediatype.MediaType

fun MediaType.getIcon(): Int {
    return when (this) {
        MediaType.MOVIE -> R.drawable.ic_movie
        MediaType.TV -> R.drawable.ic_tv
        MediaType.PERSON -> R.drawable.ic_person
        MediaType.UNKNOWN -> R.drawable.ic_unknown
    }
}
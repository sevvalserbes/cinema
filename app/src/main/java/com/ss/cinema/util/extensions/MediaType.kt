package com.ss.cinema.util.extensions

import com.ss.cinema.R
import com.ss.cinema.util.mediatype.MediaType

private const val MOVIE = "movie"
private const val TV = "tv"
private const val PERSON = "person"
private const val UNKNOWN = "unknown"

fun MediaType.getIcon(): Int {
    return when (this) {
        MediaType.MOVIE -> R.drawable.ic_movie
        MediaType.TV -> R.drawable.ic_tv
        MediaType.PERSON -> R.drawable.ic_person
        MediaType.UNKNOWN -> R.drawable.ic_unknown
    }
}

fun MediaType.getName(): String {
    return when (this) {
        MediaType.MOVIE -> MOVIE
        MediaType.TV -> TV
        MediaType.PERSON -> PERSON
        MediaType.UNKNOWN -> UNKNOWN
    }
}
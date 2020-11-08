package com.ss.cinema.util.mediatype

import javax.inject.Inject

class MediaTypeDecider @Inject constructor() {
    fun getMediaType(mediaType: String?): MediaType {
        return when (mediaType) {
            TYPE_MOVIE -> MediaType.MOVIE
            TYPE_TV -> MediaType.TV
            TYPE_PERSON -> MediaType.PERSON
            else -> MediaType.UNKNOWN
        }
    }

    companion object {
        const val TYPE_MOVIE = "movie"
        const val TYPE_TV = "tv"
        const val TYPE_PERSON = "person"
    }
}
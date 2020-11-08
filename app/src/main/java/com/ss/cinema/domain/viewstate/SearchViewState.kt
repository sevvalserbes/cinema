package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.MultiSearch
import com.ss.cinema.util.extensions.getIcon
import com.ss.cinema.util.mediatype.MediaType

class SearchViewState(private val multiSearch: MultiSearch) {

    fun getId(): Int = multiSearch.id

    fun getMediaType() = multiSearch.mediaType

    fun getName(): String {
        return when (multiSearch.mediaType) {
            MediaType.MOVIE -> multiSearch.originalTitle
            MediaType.TV -> multiSearch.originalName
            MediaType.PERSON -> multiSearch.name
            MediaType.UNKNOWN -> "Unknown"
        }
    }

    fun getImageUrl(): String {
        return when (multiSearch.mediaType) {
            MediaType.MOVIE, MediaType.TV -> multiSearch.posterPath
            MediaType.PERSON -> multiSearch.profilePath
            MediaType.UNKNOWN -> ""
        }
    }

    fun getIcon(): Int = multiSearch.mediaType.getIcon()
}
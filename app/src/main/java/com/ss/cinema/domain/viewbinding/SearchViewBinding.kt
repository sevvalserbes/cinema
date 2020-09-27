package com.ss.cinema.domain.viewbinding

import com.ss.cinema.R
import com.ss.cinema.domain.model.MultiSearch
import com.ss.cinema.util.MediaType

class SearchViewBinding(private val multiSearch: MultiSearch) {

    fun getId(): Int = multiSearch.id

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

    fun getIcon(): Int {
        return when (multiSearch.mediaType) {
            MediaType.MOVIE -> R.drawable.ic_movie
            MediaType.TV -> R.drawable.ic_tv
            MediaType.PERSON -> R.drawable.ic_person
            MediaType.UNKNOWN -> R.drawable.ic_unknown
        }
    }
}
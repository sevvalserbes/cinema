package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.Movie

class MovieViewState(private val movie: Movie) {

    fun getId() = movie.id

    fun getOriginalTitle() = movie.originalTitle

    fun getPosterImageUrl() = movie.posterPath

    fun getVoteAverage() = movie.voteAverage.toString()

    fun getReleaseDate() = movie.releaseDate
}
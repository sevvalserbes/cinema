package com.ss.cinema.domain.viewbinding

import com.ss.cinema.domain.model.Movie

class MovieViewBinding(private val movie: Movie) {
    fun getOriginalTitle() = movie.originalTitle

    fun getPosterImageUrl() = movie.posterPath

    fun getVoteAverage() = movie.voteAverage.toString()

    fun getReleaseDate() = movie.releaseDate
}
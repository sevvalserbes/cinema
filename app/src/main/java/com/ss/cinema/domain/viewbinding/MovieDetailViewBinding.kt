package com.ss.cinema.domain.viewbinding

import com.ss.cinema.domain.model.MovieDetail
import com.ss.cinema.util.extensions.yearToString

class MovieDetailViewBinding(private val movieDetail: MovieDetail) {

    fun getOriginalTitle() = movieDetail.originalTitle

    fun getOverview() = movieDetail.overview

    fun getVoteAverage() = movieDetail.voteAverage.toString()

    fun getVoteCount() = "${movieDetail.voteCount} votes"

    fun getReleaseYear() = movieDetail.releaseDate.yearToString()

    fun getRuntime() = "${movieDetail.runtime} min."

    fun getPosterPath() = movieDetail.posterPath
}
package com.ss.cinema.domain.viewbinding

import com.ss.cinema.domain.model.TvSeries

class TvSeriesViewBinding(private val tvSeries: TvSeries) {

    fun getOriginalName() = tvSeries.originalName

    fun getPosterImageUrl() = tvSeries.posterPath

    fun getVoteAverage() = tvSeries.voteAverage.toString()
}
package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.TvSeries

class TvSeriesViewState(private val tvSeries: TvSeries) {

    fun getId() = tvSeries.id

    fun getOriginalName() = tvSeries.originalName

    fun getPosterImageUrl() = tvSeries.posterPath

    fun getVoteAverage() = tvSeries.voteAverage.toString()
}
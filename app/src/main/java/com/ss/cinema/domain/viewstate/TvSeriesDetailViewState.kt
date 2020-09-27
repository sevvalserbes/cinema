package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.TvSeriesDetail

class TvSeriesDetailViewState(private val tvSeriesDetail: TvSeriesDetail) {
    fun getOriginalName() = tvSeriesDetail.originalName

    fun getOverview() = tvSeriesDetail.overview

    fun getVoteAverage() = tvSeriesDetail.voteAverage.toString()

    fun getVoteCount() = "${tvSeriesDetail.voteCount} votes"

    fun getPosterPath() = tvSeriesDetail.posterPath
}
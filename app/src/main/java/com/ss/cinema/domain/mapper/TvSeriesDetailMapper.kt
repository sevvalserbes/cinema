package com.ss.cinema.domain.mapper

import com.ss.cinema.data.remote.response.TvSeriesDetailResponse
import com.ss.cinema.domain.model.TvSeriesDetail
import javax.inject.Inject

class TvSeriesDetailMapper @Inject constructor() :
    Mapper<TvSeriesDetailResponse, TvSeriesDetail> {
    override fun mapFrom(response: TvSeriesDetailResponse): TvSeriesDetail {
        return response.let {
            TvSeriesDetail(
                originalName = it.originalName.orEmpty(),
                overview = it.overview.orEmpty(),
                voteAverage = it.voteAverage ?: 0.0,
                voteCount = it.voteCount ?: 0,
                posterPath = it.posterPath.orEmpty()
            )
        }
    }
}
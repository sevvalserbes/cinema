package com.ss.cinema.domain.mapper

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.TvSeriesResponse
import com.ss.cinema.domain.model.TvSeries
import javax.inject.Inject

class TvSeriesMapper @Inject constructor() :
    Mapper<BaseResponse<TvSeriesResponse>, List<TvSeries>> {
    override fun mapFrom(response: BaseResponse<TvSeriesResponse>): List<TvSeries> {
        return response.results?.map { tvSeriesResponse ->
            TvSeries(
                id = tvSeriesResponse.id ?: 0,
                originalName = tvSeriesResponse.originalName.orEmpty(),
                posterPath = tvSeriesResponse.posterPath.orEmpty(),
                voteAverage = tvSeriesResponse.voteAverage ?: 0
            )
        } ?: listOf()
    }
}
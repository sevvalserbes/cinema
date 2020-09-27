package com.ss.cinema.domain.mapper

import com.ss.cinema.data.remote.response.MovieDetailResponse
import com.ss.cinema.domain.model.MovieDetail
import javax.inject.Inject

class MovieDetailMapper @Inject constructor() :
    Mapper<MovieDetailResponse, MovieDetail> {
    override fun mapFrom(response: MovieDetailResponse): MovieDetail {
        return response.let {
            MovieDetail(
                originalTitle = it.originalTitle.orEmpty(),
                overview = it.overview.orEmpty(),
                voteAverage = it.voteAverage ?: 0.0,
                voteCount = it.voteCount ?: 0,
                releaseDate = it.releaseDate.orEmpty(),
                runtime = it.runtime ?: 0,
                posterPath = it.posterPath.orEmpty()
            )
        }
    }
}
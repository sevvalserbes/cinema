package com.ss.cinema.domain.mapper

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.MovieResponse
import com.ss.cinema.domain.model.Movie
import javax.inject.Inject

class MovieMapper @Inject constructor() :
    Mapper<BaseResponse<MovieResponse>, List<Movie>> {
    override fun mapFrom(response: BaseResponse<MovieResponse>): List<Movie> {
        return response.results?.map { movieResponse ->
            Movie(
                id = movieResponse.id ?: 0,
                originalTitle = movieResponse.originalTitle.orEmpty(),
                posterPath = movieResponse.posterPath.orEmpty(),
                genreIds = movieResponse.genreIds.orEmpty(), //TODO: Do not return genre IDs, return a list of genres instead
                voteAverage = movieResponse.voteAverage ?: 0,
                releaseDate = movieResponse.releaseDate.orEmpty()
            )
        } ?: listOf()
    }
}
package com.ss.cinema.domain.mapper

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.MovieResponse
import com.ss.cinema.domain.model.Movie
import javax.inject.Inject

class MovieMapper @Inject constructor() :
    Mapper<BaseResponse<MovieResponse>, List<Movie>> {
    override fun mapFrom(response: BaseResponse<MovieResponse>): List<Movie> {
        return response.results?.map { popularMovieItemResponse ->
            Movie(
                originalTitle = popularMovieItemResponse.originalTitle.orEmpty(),
                posterPath = popularMovieItemResponse.posterPath.orEmpty(),
                genreIds = popularMovieItemResponse.genreIds.orEmpty(), //TODO: Do not return genre IDs, return a list of genres instead
                voteAverage = popularMovieItemResponse.voteAverage ?: 0,
                releaseDate = popularMovieItemResponse.releaseDate.orEmpty()
            )
        } ?: listOf()
    }
}
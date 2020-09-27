package com.ss.cinema.domain.usecase

import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.data.repository.MovieRepository
import com.ss.cinema.domain.mapper.MovieDetailMapper
import com.ss.cinema.domain.model.MovieDetail
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FetchMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository,
    private val mapper: MovieDetailMapper
) {
    fun fetchMovieDetail(movieId: Int): Single<Resource<MovieDetail>> {
        return repository.fetchMovieDetail(movieId)
            .map { resource ->
                resource.map {
                    mapper.mapFrom(it)
                }
            }
    }
}
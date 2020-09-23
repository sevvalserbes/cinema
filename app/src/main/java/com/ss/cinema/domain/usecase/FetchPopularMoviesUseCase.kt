package com.ss.cinema.domain.usecase

import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.data.repository.MovieRepository
import com.ss.cinema.domain.mapper.MovieMapper
import com.ss.cinema.domain.model.Movie
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FetchPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository,
    private val mapper: MovieMapper
) {

    fun fetchPopularMovies(): Single<Resource<List<Movie>>> {
        return repository.fetchPopularMovies()
            .map { resource ->
                resource.map { baseResponse ->
                    mapper.mapFrom(baseResponse)
                }
            }
    }
}
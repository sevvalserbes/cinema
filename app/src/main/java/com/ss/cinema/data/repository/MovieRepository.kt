package com.ss.cinema.data.repository

import com.ss.cinema.data.Resource
import com.ss.cinema.data.remote.api.MovieService
import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.MovieResponse
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieService: MovieService) {

    fun fetchPopularMovies(): Single<Resource<BaseResponse<MovieResponse>>> {
        return movieService.fetchPopularMovies()
            .map<Resource<BaseResponse<MovieResponse>>> {
                Resource.Success(it)
            }.onErrorReturn {
                Resource.Error(it)
            }.subscribeOn(Schedulers.io())
    }
}
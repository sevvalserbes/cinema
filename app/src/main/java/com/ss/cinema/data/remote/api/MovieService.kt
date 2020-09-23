package com.ss.cinema.data.remote.api

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.MovieResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MovieService {

    @GET("movie/popular")
    fun fetchPopularMovies(): Single<BaseResponse<MovieResponse>>
}
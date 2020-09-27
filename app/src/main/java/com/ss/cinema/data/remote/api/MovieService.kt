package com.ss.cinema.data.remote.api

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.MovieDetailResponse
import com.ss.cinema.data.remote.response.MovieResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("movie/popular")
    fun fetchPopularMovies(): Single<BaseResponse<MovieResponse>>

    @GET("movie/{movie_id}")
    fun fetchMovieDetail(@Path("movie_id") movieId: Int): Single<MovieDetailResponse>
}
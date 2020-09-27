package com.ss.cinema.data.remote.api

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.TvSeriesDetailResponse
import com.ss.cinema.data.remote.response.TvSeriesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TvSeriesService {
    @GET("tv/popular")
    fun fetchPopularTvSeries(): Single<BaseResponse<TvSeriesResponse>>

    @GET("tv/{tv_id}")
    fun fetchTvSeriesDetail(@Path("tv_id") tvSeriesId: Int): Single<TvSeriesDetailResponse>

}
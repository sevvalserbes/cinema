package com.ss.cinema.data.remote.api

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.TvSeriesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface TvSeriesService {
    @GET("tv/popular")
    fun fetchPopularTvSeries(): Single<BaseResponse<TvSeriesResponse>>
}
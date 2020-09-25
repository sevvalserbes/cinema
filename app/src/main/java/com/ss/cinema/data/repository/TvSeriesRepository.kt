package com.ss.cinema.data.repository

import com.ss.cinema.data.Resource
import com.ss.cinema.data.remote.api.TvSeriesService
import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.TvSeriesResponse
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class TvSeriesRepository @Inject constructor(private val tvSeriesService: TvSeriesService) {

    fun fetchPopularTvSeries(): Single<Resource<BaseResponse<TvSeriesResponse>>> {
        return tvSeriesService.fetchPopularTvSeries()
            .map<Resource<BaseResponse<TvSeriesResponse>>> {
                Resource.Success(it)
            }.onErrorReturn {
                Resource.Error(it)
            }.subscribeOn(Schedulers.io())
    }
}
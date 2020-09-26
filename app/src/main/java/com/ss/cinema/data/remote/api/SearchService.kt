package com.ss.cinema.data.remote.api

import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.MultiSearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("search/multi")
    fun fetchSearchResult(@Query ("query") queryValue: String): Single<BaseResponse<MultiSearchResponse>>
}
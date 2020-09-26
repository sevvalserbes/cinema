package com.ss.cinema.data.repository

import com.ss.cinema.data.Resource
import com.ss.cinema.data.remote.api.SearchService
import com.ss.cinema.data.remote.response.BaseResponse
import com.ss.cinema.data.remote.response.MultiSearchResponse
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SearchRepository @Inject constructor(private val searchService: SearchService) {

    fun fetchSearchResult(queryValue: String): Single<Resource<BaseResponse<MultiSearchResponse>>> {
        return searchService.fetchSearchResult(queryValue)
            .map<Resource<BaseResponse<MultiSearchResponse>>> {
                Resource.Success(it)
            }.onErrorReturn {
                Resource.Error(it)
            }.subscribeOn(Schedulers.io())
    }
}
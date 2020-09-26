package com.ss.cinema.domain.usecase

import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.data.repository.SearchRepository
import com.ss.cinema.domain.mapper.MultiSearchMapper
import com.ss.cinema.domain.model.MultiSearch
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FetchMultiSearchResultUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
    private val multiSearchMapper: MultiSearchMapper
) {
    fun fetchSearchResult(queryValue: String): Single<Resource<List<MultiSearch>>> {
        return searchRepository.fetchSearchResult(queryValue)
            .map { resource ->
                resource.map { baseResponse ->
                    multiSearchMapper.mapFrom(baseResponse)
                }
            }
    }
}
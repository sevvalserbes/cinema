package com.ss.cinema.domain.usecase

import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.data.repository.TvSeriesRepository
import com.ss.cinema.domain.mapper.TvSeriesDetailMapper
import com.ss.cinema.domain.model.TvSeriesDetail
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FetchTvSeriesDetailUseCase @Inject constructor(
    private val repository: TvSeriesRepository,
    private val mapper: TvSeriesDetailMapper
) {
    fun fetchTvSeriesDetail(tvSeriesId: Int): Single<Resource<TvSeriesDetail>> {
        return repository.fetchTvSeriesDetail(tvSeriesId)
            .map { resource ->
                resource.map {
                    mapper.mapFrom(it)
                }
            }
    }
}
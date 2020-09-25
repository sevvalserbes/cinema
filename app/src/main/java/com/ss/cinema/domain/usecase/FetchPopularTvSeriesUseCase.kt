package com.ss.cinema.domain.usecase

import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.data.repository.TvSeriesRepository
import com.ss.cinema.domain.mapper.TvSeriesMapper
import com.ss.cinema.domain.model.TvSeries
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FetchPopularTvSeriesUseCase @Inject constructor(
    private val repository: TvSeriesRepository,
    private val mapper: TvSeriesMapper
) {
    fun fetchPopularTvSeries(): Single<Resource<List<TvSeries>>> {
        return repository.fetchPopularTvSeries()
            .map { resource ->
                resource.map { baseResponse ->
                    mapper.mapFrom(baseResponse)
                }
            }
    }
}
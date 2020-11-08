package com.ss.cinema.domain.usecase

import com.ss.cinema.data.repository.WatchlistRepository
import com.ss.cinema.domain.mapper.WatchlistItemMapper
import com.ss.cinema.domain.model.WatchlistItem
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class FetchWatchlistItemsUseCase @Inject constructor(
    private val repository: WatchlistRepository,
    private val mapper: WatchlistItemMapper
) {
    fun fetchWatchlistItems(): Flowable<List<WatchlistItem>> {
        return repository.fetchWatchlistItems()
            .map {
                mapper.mapFrom(it)
            }
    }
}
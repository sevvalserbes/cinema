package com.ss.cinema.domain.usecase

import com.ss.cinema.data.repository.WatchlistRepository
import com.ss.cinema.domain.mapper.WatchlistEntityMapper
import com.ss.cinema.domain.model.WatchlistItem
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class InsertItemToWatchlistUseCase @Inject constructor(
    private val watchlistRepository: WatchlistRepository,
    private val mapper: WatchlistEntityMapper
) {
    fun insertItemToWatchlist(watchlistItem: WatchlistItem): Completable {
        return watchlistRepository.insertWatchlistItem(mapper.mapFrom(watchlistItem))
    }
}
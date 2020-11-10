package com.ss.cinema.domain.usecase

import com.ss.cinema.data.repository.WatchlistRepository
import com.ss.cinema.domain.mapper.WatchlistEntityMapper
import com.ss.cinema.domain.model.WatchlistItem
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class DeleteWatchlistItemUseCase @Inject constructor(
    private val repository: WatchlistRepository,
    private val mapper: WatchlistEntityMapper
) {
    fun deleteWatchlistItem(watchlistItem: WatchlistItem): Completable {
        return repository.deleteWatchlistItem(mapper.mapFrom(watchlistItem))
    }
}
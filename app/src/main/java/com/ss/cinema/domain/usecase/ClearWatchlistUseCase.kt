package com.ss.cinema.domain.usecase

import com.ss.cinema.data.repository.WatchlistRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class ClearWatchlistUseCase @Inject constructor(
    private val watchlistRepository: WatchlistRepository
) {
    fun clearWatchlist(): Completable {
        return watchlistRepository.clearWatchlist()
    }
}
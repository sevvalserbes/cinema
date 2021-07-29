package com.ss.cinema.domain.usecase

import com.ss.cinema.data.repository.WatchlistRepository
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.util.mediatype.MediaTypeDecider
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class CheckIfItemIsInWatchlistUseCase @Inject constructor(
    private val watchlistRepository: WatchlistRepository,
    private val decider: MediaTypeDecider
) {
    fun checkIfItemIsInWatchlist(itemId: String): Flowable<WatchlistItem> {
        return watchlistRepository.getWatchlistItem(itemId)
            .map {
                WatchlistItem(
                    id = it?.id.orEmpty(),
                    name = it?.name.orEmpty(),
                    mediaType = decider.getMediaType(it?.mediaType)
                )
            }
    }
}
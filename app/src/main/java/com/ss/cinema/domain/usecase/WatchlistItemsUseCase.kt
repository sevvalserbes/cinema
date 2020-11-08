package com.ss.cinema.domain.usecase

import com.ss.cinema.data.repository.WatchlistRepository
import com.ss.cinema.domain.mapper.WatchlistItemMapper
import javax.inject.Inject

class WatchlistItemsUseCase @Inject constructor(
    private val repository: WatchlistRepository,
    private val mapper: WatchlistItemMapper
)
package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.util.extensions.getIcon

class WatchlistItemViewState(private val watchlistItem: WatchlistItem) {

    fun getName() = watchlistItem.name

    fun getIcon() = watchlistItem.mediaType.getIcon()
}
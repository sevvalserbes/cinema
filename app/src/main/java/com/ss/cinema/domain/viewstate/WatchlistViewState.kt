package com.ss.cinema.domain.viewstate

class WatchlistViewState(private val watchlistSize: Int) {

    fun clearButtonEnabled() = watchlistSize > 0
}
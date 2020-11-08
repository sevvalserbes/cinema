package com.ss.cinema.data.repository

import com.ss.cinema.data.local.database.dao.WatchlistDao
import com.ss.cinema.data.local.database.entity.WatchlistEntity
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class WatchlistRepository @Inject constructor(
    private val watchlistDao: WatchlistDao
) {
    fun fetchWatchlistItems(): Flowable<List<WatchlistEntity>> {
        return watchlistDao.getAllNights()
            .subscribeOn(Schedulers.io())
    }
}
package com.ss.cinema.data.repository

import com.ss.cinema.data.local.database.dao.WatchlistDao
import com.ss.cinema.data.local.database.entity.WatchlistEntity
import io.reactivex.rxjava3.core.Completable
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

    fun insertWatchlistItem(watchlistEntity: WatchlistEntity): Completable {
        return watchlistDao.insert(watchlistEntity)
            .subscribeOn(Schedulers.io())
    }

    fun getWatchlistItem(itemId: Int): Flowable<WatchlistEntity?> {
        return watchlistDao.get(itemId.toLong())
            .subscribeOn(Schedulers.io())
    }

    fun clearWatchlist(): Completable {
        return watchlistDao.clear()
            .subscribeOn(Schedulers.io())
    }
}
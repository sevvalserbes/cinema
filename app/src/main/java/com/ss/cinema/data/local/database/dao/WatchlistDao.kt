package com.ss.cinema.data.local.database.dao

import androidx.room.*
import com.ss.cinema.data.local.database.entity.WatchlistEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface WatchlistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(watchlistEntity: WatchlistEntity): Completable

    @Update
    fun update(watchlistEntity: WatchlistEntity): Completable

    @Transaction
    @Query(value = "SELECT * from watchlist_table WHERE watchlist_item_id = :key")
    fun get(key: String): Flowable<WatchlistEntity?>

    @Query("DELETE FROM watchlist_table")
    fun clear(): Completable

    @Delete
    fun delete(watchlistEntity: WatchlistEntity): Completable

    @Transaction
    @Query("SELECT * FROM watchlist_table ORDER BY watchlist_item_added_date DESC")
    fun getAllWatchlistItems(): Flowable<List<WatchlistEntity>>
}
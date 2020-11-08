package com.ss.cinema.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ss.cinema.data.local.database.entity.WatchlistItem

@Dao
interface WatchlistDao {

    @Insert
    fun insert(watchlistItem: WatchlistItem)

    @Update
    fun update(watchlistItem: WatchlistItem)

    @Query(value = "SELECT * from watchlist_table WHERE watchlist_item_id = :key")
    fun get(key: Long): WatchlistItem?

    @Query("DELETE FROM watchlist_table")
    fun clear()

    @Query("SELECT * FROM watchlist_table")
    fun getAllNights(): LiveData<List<WatchlistItem>>
}
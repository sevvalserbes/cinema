package com.ss.cinema.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ss.cinema.data.local.database.dao.WatchlistDao
import com.ss.cinema.data.local.database.entity.WatchlistItem

@Database(entities = [WatchlistItem::class], version = 1, exportSchema = false)
abstract class CinemaDatabase : RoomDatabase(){
    abstract val watchlistDao: WatchlistDao
}
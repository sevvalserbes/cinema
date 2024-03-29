package com.ss.cinema.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watchlist_table")
data class WatchlistEntity(
    @ColumnInfo(name = "watchlist_item_id") @PrimaryKey
    var id: String = "0",
    @ColumnInfo(name = "watchlist_item_name")
    var name: String = "item",
    @ColumnInfo(name = "watchlist_item_media_type")
    var mediaType: String = "other",
    @ColumnInfo(name = "watchlist_item_added_date")
    var addedDate: String
)
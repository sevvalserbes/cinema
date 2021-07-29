package com.ss.cinema.domain.mapper

import com.ss.cinema.data.local.database.entity.WatchlistEntity
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.util.extensions.getName
import java.util.*
import javax.inject.Inject

class WatchlistEntityMapper @Inject constructor() :
    Mapper<WatchlistItem, WatchlistEntity> {
    override fun mapFrom(response: WatchlistItem): WatchlistEntity {
        return WatchlistEntity(
            id = response.id,
            name = response.name,
            mediaType = response.mediaType.getName(),
            addedDate = if (response.addedDate == null) Date().toString() else response.addedDate.toString()
        )
    }
}
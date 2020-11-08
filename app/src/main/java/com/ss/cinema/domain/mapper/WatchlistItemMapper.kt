package com.ss.cinema.domain.mapper

import com.ss.cinema.data.local.database.entity.WatchlistEntity
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.util.mediatype.MediaTypeDecider
import javax.inject.Inject

class WatchlistItemMapper @Inject constructor(private val decider: MediaTypeDecider) :
    Mapper<List<WatchlistEntity>, List<WatchlistItem>> {
    override fun mapFrom(response: List<WatchlistEntity>): List<WatchlistItem> {
        return response.map {
            WatchlistItem(it.name, decider.getMediaType(it.mediaType))
        }
    }
}
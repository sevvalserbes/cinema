package com.ss.cinema.domain.viewstate

import com.ss.cinema.R
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.util.mediatype.MediaType
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class WatchlistItemViewStateTest {

    private var watchlistItem: WatchlistItem? = null
    private var watchlistItemViewState: WatchlistItemViewState? = null

    @Before
    fun setUp() {
        watchlistItem = WatchlistItem(
            id = 1,
            name = "Matrix",
            mediaType = MediaType.MOVIE
        )
        watchlistItemViewState = WatchlistItemViewState(watchlistItem!!)
    }

    @Test
    fun getName() {
        Assert.assertEquals("Matrix", watchlistItemViewState!!.getName())
    }

    @Test
    fun getIcon() {
        Assert.assertEquals(R.drawable.ic_movie, watchlistItemViewState!!.getIcon())
    }

    @After
    fun tearDown() {
        watchlistItem = null
    }
}
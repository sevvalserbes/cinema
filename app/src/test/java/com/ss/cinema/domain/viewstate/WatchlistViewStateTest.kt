package com.ss.cinema.domain.viewstate

import com.ss.cinema.R
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.util.mediatype.MediaType
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class WatchlistViewStateTest {

    private var watchlistItem: WatchlistItem? = null
    private var watchlistViewState: WatchlistViewState? = null

    @Before
    fun setUp() {
        watchlistItem = WatchlistItem(
            id = 1,
            name = "Matrix",
            mediaType = MediaType.MOVIE
        )
        watchlistViewState = WatchlistViewState(watchlistItem!!)
    }

    @Test
    fun getName() {
        Assert.assertEquals("Matrix", watchlistViewState!!.getName())
    }

    @Test
    fun getIcon() {
        Assert.assertEquals(R.drawable.ic_movie, watchlistViewState!!.getIcon())
    }

    @After
    fun tearDown() {
        watchlistItem = null
    }
}
package com.ss.cinema.domain.viewstate

import com.ss.cinema.R
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.util.mediatype.MediaType
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class WatchlistItemViewStateTest(
    private val expectedId: String,
    private val expectedName: String,
    private val expectedIcon: Int,
    private val watchlistItem: WatchlistItem
) {
    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any?>> {
            return arrayListOf(
                arrayOf(
                    "1",
                    "Matrix",
                    R.drawable.ic_movie,
                    WatchlistItem("1", "Matrix", MediaType.MOVIE)
                ),
                arrayOf(
                    "2",
                    "Sherlock",
                    R.drawable.ic_tv,
                    WatchlistItem("2", "Sherlock", MediaType.TV)
                ),
            )
        }
    }

    @Test
    fun getId() {
        val watchlistItemViewState = WatchlistItemViewState(watchlistItem)
        Assert.assertEquals(expectedId, watchlistItemViewState.getId())
    }

    @Test
    fun getName() {
        val watchlistItemViewState = WatchlistItemViewState(watchlistItem)
        Assert.assertEquals(expectedName, watchlistItemViewState.getName())
    }

    @Test
    fun getIcon() {
        val watchlistItemViewState = WatchlistItemViewState(watchlistItem)
        Assert.assertEquals(expectedIcon, watchlistItemViewState.getIcon())
    }
}
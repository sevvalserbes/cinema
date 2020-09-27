package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.TvSeries
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TvSeriesViewStateTest {

    private var tvSeries: TvSeries? = null
    private var tvSeriesViewState: TvSeriesViewState? = null

    @Before
    fun setUp() {
        tvSeries = TvSeries(
            id = 0,
            originalName = "Dark",
            posterPath = "posterPath",
            voteAverage = 9.3
        )
        tvSeriesViewState = TvSeriesViewState(tvSeries!!)
    }

    @Test
    fun `given TvSeriesViewState created, then get originalName`() {
        assertEquals("Dark", tvSeriesViewState!!.getOriginalName())
    }

    @Test
    fun `given TvSeriesViewState created, then get image url for posterPath`() {
        assertEquals("posterPath", tvSeriesViewState!!.getPosterImageUrl())
    }

    @Test
    fun `given TvSeriesViewState created, then get voteAverage`() {
        assertEquals("9.3", tvSeriesViewState!!.getVoteAverage())
    }

    @After
    fun tearDown() {
        tvSeries = null
        tvSeriesViewState = null
    }
}
package com.ss.cinema.domain.viewbinding

import com.ss.cinema.domain.model.TvSeries
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TvSeriesViewBindingTest {

    private var tvSeries: TvSeries? = null
    private var tvSeriesViewBinding: TvSeriesViewBinding? = null

    @Before
    fun setUp() {
        tvSeries = TvSeries(
            id = 0,
            originalName = "Dark",
            posterPath = "posterPath",
            voteAverage = 9.3
        )
        tvSeriesViewBinding = TvSeriesViewBinding(tvSeries!!)
    }

    @Test
    fun `given TvSeriesViewBinding created, then get originalName`() {
        assertEquals("Dark", tvSeriesViewBinding!!.getOriginalName())
    }

    @Test
    fun `given TvSeriesViewBinding created, then get image url for posterPath`() {
        assertEquals("posterPath", tvSeriesViewBinding!!.getPosterImageUrl())
    }

    @Test
    fun `given TvSeriesViewBinding created, then get voteAverage`() {
        assertEquals("9.3", tvSeriesViewBinding!!.getVoteAverage())
    }

    @After
    fun tearDown() {
        tvSeries = null
        tvSeriesViewBinding = null
    }
}
package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.TvSeriesDetail
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvSeriesDetailViewStateTest {

    private var tvSeriesDetail: TvSeriesDetail? = null
    private var tvSeriesDetailViewState: TvSeriesDetailViewState? = null

    @Before
    fun setUp() {
        tvSeriesDetail = TvSeriesDetail(
            originalName = "Sherlock",
            overview = "overview",
            voteAverage = 9.4,
            voteCount = 234545,
            posterPath = "posterPath"
        )
        tvSeriesDetailViewState = TvSeriesDetailViewState(tvSeriesDetail!!)
    }

    @Test
    fun `given TvSeriesDetailViewState created, then get originalName`() {
        Assert.assertEquals("Sherlock", tvSeriesDetailViewState!!.getOriginalName())
    }

    @Test
    fun `given TvSeriesDetailViewState created, then get overview`() {
        Assert.assertEquals("overview", tvSeriesDetailViewState!!.getOverview())
    }

    @Test
    fun `given TvSeriesDetailViewState created, then get voteAverage in string`() {
        Assert.assertEquals("9.4", tvSeriesDetailViewState!!.getVoteAverage())
    }

    @Test
    fun `given TvSeriesDetailViewState created, then get voteCount in the wanted format`() {
        Assert.assertEquals("234545 votes", tvSeriesDetailViewState!!.getVoteCount())
    }

    @Test
    fun `given TvSeriesDetailViewState created, then get posterPath`() {
        Assert.assertEquals("posterPath", tvSeriesDetailViewState!!.getPosterPath())
    }

    @After
    fun tearDown() {
        tvSeriesDetail = null
        tvSeriesDetailViewState = null
    }
}
package com.ss.cinema.domain.viewbinding

import com.ss.cinema.domain.model.TvSeriesDetail
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvSeriesDetailViewBindingTest {

    private var tvSeriesDetail: TvSeriesDetail? = null
    private var tvSeriesDetailViewBinding: TvSeriesDetailViewBinding? = null

    @Before
    fun setUp() {
        tvSeriesDetail = TvSeriesDetail(
            originalName = "Sherlock",
            overview = "overview",
            voteAverage = 9.4,
            voteCount = 234545,
            posterPath = "posterPath"
        )
        tvSeriesDetailViewBinding = TvSeriesDetailViewBinding(tvSeriesDetail!!)
    }

    @Test
    fun `given TvSeriesDetailViewBinding created, then get originalName`() {
        Assert.assertEquals("Sherlock", tvSeriesDetailViewBinding!!.getOriginalName())
    }

    @Test
    fun `given TvSeriesDetailViewBinding created, then get overview`() {
        Assert.assertEquals("overview", tvSeriesDetailViewBinding!!.getOverview())
    }

    @Test
    fun `given TvSeriesDetailViewBinding created, then get voteAverage in string`() {
        Assert.assertEquals("9.4", tvSeriesDetailViewBinding!!.getVoteAverage())
    }

    @Test
    fun `given TvSeriesDetailViewBinding created, then get voteCount in the wanted format`() {
        Assert.assertEquals("234545 votes", tvSeriesDetailViewBinding!!.getVoteCount())
    }

    @Test
    fun `given TvSeriesDetailViewBinding created, then get posterPath`() {
        Assert.assertEquals("posterPath", tvSeriesDetailViewBinding!!.getPosterPath())
    }

    @After
    fun tearDown() {
        tvSeriesDetail = null
        tvSeriesDetailViewBinding = null
    }
}
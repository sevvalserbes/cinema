package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.MovieDetail
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieDetailViewStateTest {

    private var movieDetail: MovieDetail? = null
    private var movieDetailViewState: MovieDetailViewState? = null

    @Before
    fun setUp() {
        movieDetail = MovieDetail(
            originalTitle = "Deadpool",
            overview = "overview",
            voteAverage = 9.4,
            voteCount = 234545,
            releaseDate = "2018-01-02",
            runtime = 105,
            posterPath = "posterPath"
        )
        movieDetailViewState = MovieDetailViewState(movieDetail!!)
    }

    @Test
    fun `given MovieDetailViewState created, then get originalTitle`() {
        Assert.assertEquals("Deadpool", movieDetailViewState!!.getOriginalTitle())
    }

    @Test
    fun `given MovieDetailViewState created, then get overview`() {
        Assert.assertEquals("overview", movieDetailViewState!!.getOverview())
    }

    @Test
    fun `given MovieDetailViewState created, then get voteAverage in string`() {
        Assert.assertEquals("9.4", movieDetailViewState!!.getVoteAverage())
    }

    @Test
    fun `given MovieDetailViewState created, then get voteCount in the wanted format`() {
        Assert.assertEquals("234545 votes", movieDetailViewState!!.getVoteCount())
    }

    @Test
    fun `given MovieDetailViewState created, then get release year from the releaseDate value`() {
        Assert.assertEquals("2018", movieDetailViewState!!.getReleaseYear())
    }

    @Test
    fun `given MovieDetailViewState created, then get runtime in the wanted format`() {
        Assert.assertEquals("105 min.", movieDetailViewState!!.getRuntime())
    }

    @Test
    fun `given MovieDetailViewState created, then get posterPath`() {
        Assert.assertEquals("posterPath", movieDetailViewState!!.getPosterPath())
    }

    @After
    fun tearDown() {
        movieDetail = null
        movieDetailViewState = null
    }
}
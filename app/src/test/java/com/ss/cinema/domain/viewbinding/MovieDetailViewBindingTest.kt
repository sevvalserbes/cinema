package com.ss.cinema.domain.viewbinding

import com.ss.cinema.domain.model.MovieDetail
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieDetailViewBindingTest {

    private var movieDetail: MovieDetail? = null
    private var movieDetailViewBinding: MovieDetailViewBinding? = null

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
        movieDetailViewBinding = MovieDetailViewBinding(movieDetail!!)
    }

    @Test
    fun `given MovieDetailViewBinding created, then get originalTitle`() {
        Assert.assertEquals("Deadpool", movieDetailViewBinding!!.getOriginalTitle())
    }

    @Test
    fun `given MovieDetailViewBinding created, then get overview`() {
        Assert.assertEquals("overview", movieDetailViewBinding!!.getOverview())
    }

    @Test
    fun `given MovieDetailViewBinding created, then get voteAverage in string`() {
        Assert.assertEquals("9.4", movieDetailViewBinding!!.getVoteAverage())
    }

    @Test
    fun `given MovieDetailViewBinding created, then get voteCount in the wanted format`() {
        Assert.assertEquals("234545 votes", movieDetailViewBinding!!.getVoteCount())
    }

    @Test
    fun `given MovieDetailViewBinding created, then get release year from the releaseDate value`() {
        Assert.assertEquals("2018", movieDetailViewBinding!!.getReleaseYear())
    }

    @Test
    fun `given MovieDetailViewBinding created, then get runtime in the wanted format`() {
        Assert.assertEquals("105 min.", movieDetailViewBinding!!.getRuntime())
    }

    @Test
    fun `given MovieDetailViewBinding created, then get posterPath`() {
        Assert.assertEquals("posterPath", movieDetailViewBinding!!.getPosterPath())
    }

    @After
    fun tearDown() {
        movieDetail = null
        movieDetailViewBinding = null
    }
}
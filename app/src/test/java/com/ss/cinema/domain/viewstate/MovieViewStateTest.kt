package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.Movie
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MovieViewStateTest {

    private var movie: Movie? = null
    private var movieViewState: MovieViewState? = null

    @Before
    fun setUp() {
        movie = Movie(
            id = 0,
            originalTitle = "Memento",
            posterPath = "posterPath",
            voteAverage = 9.3,
            releaseDate = "releaseDate"
        )
        movieViewState = MovieViewState(movie!!)
    }

    @Test
    fun `given MovieViewState created, then get originalTitle`() {
        assertEquals("Memento", movieViewState!!.getOriginalTitle())
    }

    @Test
    fun `given MovieViewState created, then get posterPath`() {
        assertEquals("posterPath", movieViewState!!.getPosterImageUrl())
    }

    @Test
    fun `given MovieViewState created, then get voteAverage`() {
        assertEquals("9.3", movieViewState!!.getVoteAverage())
    }

    @Test
    fun `given MovieViewState created, then get releaseDate`() {
        assertEquals("releaseDate", movieViewState!!.getReleaseDate())
    }

    @After
    fun tearDown() {
        movie = null
        movieViewState = null
    }
}
package com.ss.cinema.domain.viewbinding

import com.ss.cinema.domain.model.Movie
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MovieViewBindingTest {

    private var movie: Movie? = null
    private var movieViewBinding: MovieViewBinding? = null

    @Before
    fun setUp() {
        movie = Movie(
            id = 0,
            originalTitle = "Memento",
            posterPath = "posterPath",
            genreIds = listOf<Int>(),
            voteAverage = 9.3,
            releaseDate = "releaseDate"
        )
        movieViewBinding = MovieViewBinding(movie!!)
    }

    @Test
    fun `given MovieViewBinding created, then get originalTitle`() {
        assertEquals("Memento", movieViewBinding!!.getOriginalTitle())
    }

    @Test
    fun `given MovieViewBinding created, then get posterPath`() {
        assertEquals("posterPath", movieViewBinding!!.getPosterImageUrl())
    }

    @Test
    fun `given MovieViewBinding created, then get voteAverage`() {
        assertEquals("9.3", movieViewBinding!!.getVoteAverage())
    }

    @Test
    fun `given MovieViewBinding created, then get releaseDate`() {
        assertEquals("releaseDate", movieViewBinding!!.getReleaseDate())
    }

    @After
    fun tearDown() {
        movie = null
        movieViewBinding = null
    }
}
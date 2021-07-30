package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.Movie
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class MovieViewStateTest(

    private val expectedTitle: String,
    private val expectedPosterPath: String,
    private val expectedVote: String,
    private val expectedReleaseDate: String,
    private val movie: Movie
) {

    private lateinit var movieViewState: MovieViewState

    @Before
    fun setUp() {
        movieViewState = MovieViewState(movie)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any?>> {
            return arrayListOf(
                arrayOf(
                    "Memento",
                    "posterPath",
                    "9.3",
                    "2018",
                    Movie(
                        id = 0,
                        originalTitle = "Memento",
                        posterPath = "posterPath",
                        voteAverage = 9.3,
                        releaseDate = "2018"
                    )
                )
            )
        }
    }

    @Test
    fun `given MovieViewState created, then get originalTitle`() {
        assertEquals(expectedTitle, movieViewState.getOriginalTitle())
    }

    @Test
    fun `given MovieViewState created, then get posterPath`() {
        assertEquals(expectedPosterPath, movieViewState.getPosterImageUrl())
    }

    @Test
    fun `given MovieViewState created, then get voteAverage`() {
        assertEquals(expectedVote, movieViewState.getVoteAverage())
    }

    @Test
    fun `given MovieViewState created, then get releaseDate`() {
        assertEquals(expectedReleaseDate, movieViewState.getReleaseDate())
    }
}
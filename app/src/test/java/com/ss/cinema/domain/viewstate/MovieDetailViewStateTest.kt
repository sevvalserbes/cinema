package com.ss.cinema.domain.viewstate

import com.ss.cinema.domain.model.MovieDetail
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class MovieDetailViewStateTest(
    private val expectedTitle: String,
    private val expectedOverview: String,
    private val expectedVote: String,
    private val expectedVoteCount: String,
    private val expectedReleaseDate: String,
    private val expectedRuntime: String,
    private val expectedPosterPath: String,
    private val movieDetail: MovieDetail

) {

    private lateinit var movieDetailViewState: MovieDetailViewState

    @Before
    fun setUp() {
        movieDetailViewState = MovieDetailViewState(movieDetail)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any?>> {
            return arrayListOf(
                arrayOf(
                    "Deadpool",
                    "overview",
                    "9.4",
                    "234545 votes",
                    "2018",
                    "105 min.",
                    "posterPath",
                    MovieDetail(
                        originalTitle = "Deadpool",
                        overview = "overview",
                        voteAverage = 9.4,
                        voteCount = 234545,
                        releaseDate = "2018-01-02",
                        runtime = 105,
                        posterPath = "posterPath"
                    )
                )
            )
        }
    }

    @Test
    fun `given MovieDetailViewState created, then get originalTitle`() {
        Assert.assertEquals(expectedTitle, movieDetailViewState.getOriginalTitle())
    }

    @Test
    fun `given MovieDetailViewState created, then get overview`() {
        Assert.assertEquals(expectedOverview, movieDetailViewState.getOverview())
    }

    @Test
    fun `given MovieDetailViewState created, then get voteAverage in string`() {
        Assert.assertEquals(expectedVote, movieDetailViewState.getVoteAverage())
    }

    @Test
    fun `given MovieDetailViewState created, then get voteCount in the wanted format`() {
        Assert.assertEquals(expectedVoteCount, movieDetailViewState.getVoteCount())
    }

    @Test
    fun `given MovieDetailViewState created, then get release year from the releaseDate value`() {
        Assert.assertEquals(expectedReleaseDate, movieDetailViewState.getReleaseYear())
    }

    @Test
    fun `given MovieDetailViewState created, then get runtime in the wanted format`() {
        Assert.assertEquals(expectedRuntime, movieDetailViewState.getRuntime())
    }

    @Test
    fun `given MovieDetailViewState created, then get posterPath`() {
        Assert.assertEquals(expectedPosterPath, movieDetailViewState.getPosterPath())
    }
}
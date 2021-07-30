package com.ss.cinema.domain.viewstate

import com.ss.cinema.R
import com.ss.cinema.domain.model.MultiSearch
import com.ss.cinema.util.mediatype.MediaType
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class SearchViewStateTest(
    private val expectedId: Int,
    private val expectedMediaType: MediaType,
    private val expectedName: String,
    private val expectedImageUrl: String,
    private val expectedIcon: Int,
    private val multiSearch: MultiSearch
) {

    private lateinit var searchViewState: SearchViewState

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any?>> {
            return arrayListOf(
                arrayOf(
                    0,
                    MediaType.PERSON,
                    "Andrew Scott",
                    "profilePath",
                    R.drawable.ic_person,
                    MultiSearch(
                        id = 0,
                        mediaType = MediaType.PERSON,
                        posterPath = "",
                        profilePath = "profilePath",
                        originalTitle = "",
                        originalName = "",
                        name = "Andrew Scott"
                    )
                ),
                arrayOf(
                    1,
                    MediaType.MOVIE,
                    "The Room",
                    "posterPath",
                    R.drawable.ic_movie,
                    MultiSearch(
                        id = 1,
                        mediaType = MediaType.MOVIE,
                        posterPath = "posterPath",
                        profilePath = "",
                        originalTitle = "The Room",
                        originalName = "",
                        name = ""
                    )
                ),
                arrayOf(
                    2,
                    MediaType.TV,
                    "Black Mirror",
                    "posterPath",
                    R.drawable.ic_tv,
                    MultiSearch(
                        id = 2,
                        mediaType = MediaType.TV,
                        posterPath = "posterPath",
                        profilePath = "",
                        originalTitle = "",
                        originalName = "Black Mirror",
                        name = ""
                    )
                ),
                arrayOf(
                    0,
                    MediaType.UNKNOWN,
                    "Unknown",
                    "",
                    R.drawable.ic_unknown,
                    MultiSearch(
                        id = 0,
                        mediaType = MediaType.UNKNOWN,
                        posterPath = "",
                        profilePath = "",
                        originalTitle = "",
                        originalName = "",
                        name = ""
                    )
                )
            )
        }
    }

    @Before
    fun setUp() {
        searchViewState = SearchViewState(multiSearch)
    }

    @Test
    fun getId() {
        assertEquals(expectedId, searchViewState.getId())
    }

    @Test
    fun getExpectedMediaType() {
        assertEquals(expectedMediaType, searchViewState.getMediaType())
    }

    @Test
    fun getName() {
        assertEquals(expectedName, searchViewState.getName())
    }

    @Test
    fun getImageUrl() {
        assertEquals(expectedImageUrl, searchViewState.getImageUrl())
    }

    @Test
    fun getIcon() {
        assertEquals(expectedIcon, searchViewState.getIcon())
    }
}
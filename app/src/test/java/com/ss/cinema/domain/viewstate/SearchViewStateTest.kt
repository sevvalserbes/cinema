package com.ss.cinema.domain.viewstate

import com.ss.cinema.R
import com.ss.cinema.domain.model.MultiSearch
import com.ss.cinema.util.mediatype.MediaType
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class SearchViewStateTest {

    private var multiSearch: MultiSearch? = null

    @Before
    fun setUp() {
        multiSearch = MultiSearch(
            id = 0,
            mediaType = MediaType.UNKNOWN,
            posterPath = "posterPath",
            profilePath = "profilePath",
            originalTitle = "Memento",
            originalName = "Dark",
            name = "Andrew Scott"
        )
    }

    @Test
    fun `given SearchViewState is created, then get id`() {
        // Given
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals(0, searchViewState.getId())
    }

    @Test
    fun `given SearchViewState is created, when media type is MOVIE, then MOVIE media type`() {
        // Given
        multiSearch!!.mediaType = MediaType.MOVIE
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals(MediaType.MOVIE, searchViewState.getMediaType())
    }

    @Test
    fun `given SearchViewState is created, when media type is TV, then TV media type`() {
        // Given
        multiSearch!!.mediaType = MediaType.TV
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals(MediaType.TV, searchViewState.getMediaType())
    }

    @Test
    fun `given SearchViewState is created, when media type is MOVIE, then get originalTitle`() {
        // Given
        multiSearch!!.mediaType = MediaType.MOVIE
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals("Memento", searchViewState.getName())
    }

    @Test
    fun `given SearchViewState is created, when media type is TV, then get originalName`() {
        // Given
        multiSearch!!.mediaType = MediaType.TV
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals("Dark", searchViewState.getName())
    }

    @Test
    fun `given SearchViewState is created, when media type is PERSON, then get name`() {
        // Given
        multiSearch!!.mediaType = MediaType.PERSON
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals("Andrew Scott", searchViewState.getName())
    }

    @Test
    fun `given SearchViewState is created, when media type is UNKNOWN, then get unknown`() {
        // Given
        multiSearch!!.mediaType = MediaType.UNKNOWN
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals("Unknown", searchViewState.getName())
    }

    @Test
    fun `given SearchViewState is created, when media type is MOVIE, then get posterPath`() {
        // Given
        multiSearch!!.mediaType = MediaType.MOVIE
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals("posterPath", searchViewState.getImageUrl())
    }

    @Test
    fun `given SearchViewState is created, when media type is TV, then get posterPath`() {
        // Given
        multiSearch!!.mediaType = MediaType.TV
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals("posterPath", searchViewState.getImageUrl())
    }

    @Test
    fun `given SearchViewState is created, when media type is PERSON, then get profilePath`() {
        // Given
        multiSearch!!.mediaType = MediaType.PERSON
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals("profilePath", searchViewState.getImageUrl())
    }

    @Test
    fun `given SearchViewState is created, when media type is UNKNOWN, then get empty string`() {
        // Given
        multiSearch!!.mediaType = MediaType.UNKNOWN
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals("", searchViewState.getImageUrl())
    }

    @Test
    fun `given SearchViewState is created, when media type is MOVIE, then get movie icon`() {
        // Given
        multiSearch!!.mediaType = MediaType.MOVIE
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals(R.drawable.ic_movie, searchViewState.getIcon())
    }

    @Test
    fun `given SearchViewState is created, when media type is TV, then get tv icon`() {
        // Given
        multiSearch!!.mediaType = MediaType.TV
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals(R.drawable.ic_tv, searchViewState.getIcon())
    }

    @Test
    fun `given SearchViewState is created, when media type is PERSON, then get person icon`() {
        // Given
        multiSearch!!.mediaType = MediaType.PERSON
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals(R.drawable.ic_person, searchViewState.getIcon())
    }

    @Test
    fun `given SearchViewState is created, when media type is UNKNOWN, then get unknown icon`() {
        // Given
        multiSearch!!.mediaType = MediaType.UNKNOWN
        val searchViewState = SearchViewState(multiSearch!!)

        // Then
        assertEquals(R.drawable.ic_unknown, searchViewState.getIcon())
    }

    @After
    fun tearDown() {
        multiSearch = null
    }
}
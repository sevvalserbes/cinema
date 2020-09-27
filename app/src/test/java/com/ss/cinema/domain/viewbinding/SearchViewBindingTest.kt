package com.ss.cinema.domain.viewbinding

import com.ss.cinema.R
import com.ss.cinema.domain.model.MultiSearch
import com.ss.cinema.util.MediaType
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class SearchViewBindingTest {

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
    fun `given SearchViewBinding is created, then get id`() {
        // Given
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals(0, searchViewBinding.getId())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is MOVIE, then MOVIE media type`() {
        // Given
        multiSearch!!.mediaType = MediaType.MOVIE
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals(MediaType.MOVIE, searchViewBinding.getMediaType())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is TV, then TV media type`() {
        // Given
        multiSearch!!.mediaType = MediaType.TV
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals(MediaType.TV, searchViewBinding.getMediaType())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is MOVIE, then get originalTitle`() {
        // Given
        multiSearch!!.mediaType = MediaType.MOVIE
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals("Memento", searchViewBinding.getName())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is TV, then get originalName`() {
        // Given
        multiSearch!!.mediaType = MediaType.TV
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals("Dark", searchViewBinding.getName())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is PERSON, then get name`() {
        // Given
        multiSearch!!.mediaType = MediaType.PERSON
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals("Andrew Scott", searchViewBinding.getName())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is UNKNOWN, then get unknown`() {
        // Given
        multiSearch!!.mediaType = MediaType.UNKNOWN
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals("Unknown", searchViewBinding.getName())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is MOVIE, then get posterPath`() {
        // Given
        multiSearch!!.mediaType = MediaType.MOVIE
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals("posterPath", searchViewBinding.getImageUrl())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is TV, then get posterPath`() {
        // Given
        multiSearch!!.mediaType = MediaType.TV
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals("posterPath", searchViewBinding.getImageUrl())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is PERSON, then get profilePath`() {
        // Given
        multiSearch!!.mediaType = MediaType.PERSON
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals("profilePath", searchViewBinding.getImageUrl())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is UNKNOWN, then get empty string`() {
        // Given
        multiSearch!!.mediaType = MediaType.UNKNOWN
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals("", searchViewBinding.getImageUrl())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is MOVIE, then get movie icon`() {
        // Given
        multiSearch!!.mediaType = MediaType.MOVIE
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals(R.drawable.ic_movie, searchViewBinding.getIcon())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is TV, then get tv icon`() {
        // Given
        multiSearch!!.mediaType = MediaType.TV
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals(R.drawable.ic_tv, searchViewBinding.getIcon())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is PERSON, then get person icon`() {
        // Given
        multiSearch!!.mediaType = MediaType.PERSON
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals(R.drawable.ic_person, searchViewBinding.getIcon())
    }

    @Test
    fun `given SearchViewBinding is created, when media type is UNKNOWN, then get unknown icon`() {
        // Given
        multiSearch!!.mediaType = MediaType.UNKNOWN
        val searchViewBinding = SearchViewBinding(multiSearch!!)

        // Then
        assertEquals(R.drawable.ic_unknown, searchViewBinding.getIcon())
    }

    @After
    fun tearDown() {
        multiSearch = null
    }
}
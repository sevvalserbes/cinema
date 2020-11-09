package com.ss.cinema.util.mediatype

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class MediaTypeDeciderTest(
    private val mediaType: String?,
    private val expected: MediaType
) {

    companion object {

        private const val MOVIE = "movie"
        private const val TV = "tv"
        private const val PERSON = "person"
        private const val UNKNOWN = "unknown"

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any?>> {
            return arrayListOf(
                arrayOf(MOVIE, MediaType.MOVIE),
                arrayOf(TV, MediaType.TV),
                arrayOf(PERSON, MediaType.PERSON),
                arrayOf(UNKNOWN, MediaType.UNKNOWN),
                arrayOf(null, MediaType.UNKNOWN)
            )
        }
    }

    @Test
    fun getMediaType() {
        val mediaTypeDecider = MediaTypeDecider()
        val actual = mediaTypeDecider.getMediaType(mediaType)
        Assert.assertEquals(expected, actual)
    }
}
package com.ss.cinema.util.extensions

import com.ss.cinema.R
import com.ss.cinema.util.mediatype.MediaType
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class MediaTypeKtTest(
    private val mediaType: MediaType,
    private val expected: Int,
    private val expectedString: String
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
                arrayOf(MediaType.MOVIE, R.drawable.ic_movie, MOVIE),
                arrayOf(MediaType.TV, R.drawable.ic_tv, TV),
                arrayOf(MediaType.PERSON, R.drawable.ic_person, PERSON),
                arrayOf(MediaType.UNKNOWN, R.drawable.ic_unknown, UNKNOWN)
            )
        }
    }

    @Test
    fun getIcon() {
        Assert.assertEquals(expected, mediaType.getIcon())
    }

    @Test
    fun getName() {
        Assert.assertEquals(expectedString, mediaType.getName())
    }
}
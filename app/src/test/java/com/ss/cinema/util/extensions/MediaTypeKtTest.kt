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
    private val expected: Int
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any?>> {
            return arrayListOf(
                arrayOf(MediaType.MOVIE, R.drawable.ic_movie),
                arrayOf(MediaType.TV, R.drawable.ic_tv),
                arrayOf(MediaType.PERSON, R.drawable.ic_person),
                arrayOf(MediaType.UNKNOWN, R.drawable.ic_unknown)
            )
        }
    }

    @Test
    fun getIcon() {
        Assert.assertEquals(expected, mediaType.getIcon())
    }
}
package com.ss.cinema.data.local.database

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ss.cinema.data.local.database.dao.WatchlistDao
import com.ss.cinema.data.local.database.entity.WatchlistItem
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CinemaDatabaseTest {

    private lateinit var watchlistDao: WatchlistDao
    private lateinit var db: CinemaDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, CinemaDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        watchlistDao = db.watchlistDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetWatchlistItem() {
        val watchlistItem = WatchlistItem(
            1,
            "Matrix",
            "movie"
        )
        watchlistDao.insert(watchlistItem)
        val movie = watchlistDao.get(1)
        assertEquals(movie?.name, "Matrix")
    }


    @Test
    @Throws(Exception::class)
    fun updateAndGetWatchlistItem() {
        var movie = WatchlistItem(
            id = 2,
            name = "Memento",
            mediaType = "movie"
        )
        watchlistDao.insert(movie)
        movie = WatchlistItem(
            id = 2,
            name = "Shrek",
            mediaType = "movie"
        )
        watchlistDao.update(movie)
        val item = watchlistDao.get(2)
        assertEquals(item?.name, "Shrek")
    }
}
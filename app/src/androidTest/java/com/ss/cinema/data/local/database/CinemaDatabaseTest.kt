package com.ss.cinema.data.local.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ss.cinema.data.local.database.dao.WatchlistDao
import com.ss.cinema.data.local.database.entity.WatchlistEntity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CinemaDatabaseTest {

    private lateinit var watchlistDao: WatchlistDao
    private lateinit var db: CinemaDatabase

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

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
        val watchlistItem = WatchlistEntity(
            "1",
            "Matrix",
            "movie",
            "2018-03-04"
        )
        watchlistDao.insert(watchlistItem).blockingAwait()
        watchlistDao.get("1")
            .test()
            .assertValue { it?.name == "Matrix" }
    }


    @Test
    @Throws(Exception::class)
    fun updateAndGetWatchlistItem() {
        var movie = WatchlistEntity(
            id = "2",
            name = "Memento",
            mediaType = "movie",
            addedDate = "2018-03-04"
        )
        watchlistDao.insert(movie).blockingAwait()
        movie = WatchlistEntity(
            id = "2",
            name = "Shrek",
            mediaType = "movie",
            addedDate = "2018-03-04"
        )
        watchlistDao.update(movie).blockingAwait()
        watchlistDao.get("2")
            .test()
            .assertValue { it?.name == "Shrek" }
    }

    @Test
    fun deleteAndGetUser() {
        val movie = WatchlistEntity(
            id = "3",
            name = "Memento",
            mediaType = "movie",
            addedDate = "2018-03-04"
        )
        watchlistDao.insert(movie).blockingAwait()
        watchlistDao.clear().blockingAwait()
        watchlistDao.get("3")
            .test()
            .assertNoValues()
    }
}
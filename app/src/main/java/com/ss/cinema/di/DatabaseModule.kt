package com.ss.cinema.di

import android.content.Context
import androidx.room.Room
import com.ss.cinema.data.local.database.CinemaDatabase
import com.ss.cinema.data.local.database.dao.WatchlistDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    private const val DATABASE_NAME = "cinema_database"

    @Provides
    @Singleton
    fun provideCinemaDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            CinemaDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideWatchlistDao(cinemaDatabase: CinemaDatabase): WatchlistDao =
        cinemaDatabase.watchlistDao
}
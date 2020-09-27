package com.ss.cinema.ui.search

interface SearchHandler {

    fun onMovieItemClick(movieId: Int)

    fun onTvSeriesItemClick(tvSeriesId: Int)
}
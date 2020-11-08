package com.ss.cinema.ui.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.domain.model.Movie
import com.ss.cinema.domain.usecase.FetchPopularMoviesUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MoviesViewModel @ViewModelInject constructor(
    private val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase
) {
    init {
        fetchPopularMovies()
    }

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    private fun fetchPopularMovies() {
        fetchPopularMoviesUseCase.fetchPopularMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resource ->
                if (resource is Resource.Success) {
                    resource.map {
                        _movies.value = it
                    }
                }
            }
    }
}
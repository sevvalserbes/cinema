package com.ss.cinema.ui.moviedetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.domain.model.MovieDetail
import com.ss.cinema.domain.usecase.FetchMovieDetailUseCase
import com.ss.cinema.util.ReactiveViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MovieDetailViewModel @ViewModelInject constructor(
    private val fetchMovieDetailUseCase: FetchMovieDetailUseCase
) : ReactiveViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() = _movieDetail

    fun fetchMovieDetail(movieId: Int) {
        fetchMovieDetailUseCase.fetchMovieDetail(movieId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resource ->
                if (resource is Resource.Success) {
                    resource.map {
                        _movieDetail.value = it
                    }
                }
            }.also {
                disposable.add(it)
            }
    }
}
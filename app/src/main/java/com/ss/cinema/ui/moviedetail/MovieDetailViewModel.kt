package com.ss.cinema.ui.moviedetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.domain.model.MovieDetail
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.domain.usecase.CheckIfItemIsInWatchlistUseCase
import com.ss.cinema.domain.usecase.FetchMovieDetailUseCase
import com.ss.cinema.domain.usecase.InsertItemToWatchlistUseCase
import com.ss.cinema.util.mediatype.MediaType
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MovieDetailViewModel @ViewModelInject constructor(
    private val fetchMovieDetailUseCase: FetchMovieDetailUseCase,
    private val insertItemToWatchlistUseCase: InsertItemToWatchlistUseCase,
    private val checkIfItemIsInWatchlistUseCase: CheckIfItemIsInWatchlistUseCase
) : ViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() = _movieDetail

    private val _showToastMessage = MutableLiveData<Boolean>()
    val showToastMessage: LiveData<Boolean>
        get() = _showToastMessage

    private val _isMovieInWatchlist = MutableLiveData<Boolean>()
    val isMovieInWatchlist: LiveData<Boolean>
        get() = _isMovieInWatchlist

    fun checkIfMovieIsInWatchlist(movieId: Int) {
        checkIfItemIsInWatchlistUseCase.checkIfItemIsInWatchlist(movieId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let {
                    _isMovieInWatchlist.value = true
                }
            }
    }

    fun fetchMovieDetail(movieId: Int) {
        fetchMovieDetailUseCase.fetchMovieDetail(movieId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resource ->
                if (resource is Resource.Success) {
                    resource.map {
                        _movieDetail.value = it
                    }
                }
            }
    }

    fun insertMovieToWatchlist(movieId: Int) {
        val watchlistItem = WatchlistItem(
            movieId,
            _movieDetail.value?.originalTitle.orEmpty(),
            MediaType.MOVIE
        )
        insertItemToWatchlistUseCase.insertMovieToWatchlist(watchlistItem)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _showToastMessage.value = true
            }
    }

    fun doneShowingToast() {
        _showToastMessage.value = false
    }
}
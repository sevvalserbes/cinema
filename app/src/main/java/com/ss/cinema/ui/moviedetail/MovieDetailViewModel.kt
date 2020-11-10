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
import com.ss.cinema.domain.usecase.DeleteWatchlistItemUseCase
import com.ss.cinema.domain.usecase.FetchMovieDetailUseCase
import com.ss.cinema.domain.usecase.InsertItemToWatchlistUseCase
import com.ss.cinema.util.mediatype.MediaType
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class MovieDetailViewModel @ViewModelInject constructor(
    private val fetchMovieDetailUseCase: FetchMovieDetailUseCase,
    private val insertItemToWatchlistUseCase: InsertItemToWatchlistUseCase,
    private val checkIfItemIsInWatchlistUseCase: CheckIfItemIsInWatchlistUseCase,
    private val deleteWatchlistItemUseCase: DeleteWatchlistItemUseCase
) : ViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() = _movieDetail

    private val _showItemAddedToastMessage = MutableLiveData<Boolean>()
    val showItemAddedToastMessage: LiveData<Boolean>
        get() = _showItemAddedToastMessage

    private val _showItemDeletedToastMessage = MutableLiveData<Boolean>()
    val showItemDeletedToastMessage: LiveData<Boolean>
        get() = _showItemDeletedToastMessage

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
        insertItemToWatchlistUseCase.insertMovieToWatchlist(getWatchlistItem(movieId))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _showItemAddedToastMessage.value = true
            }
    }

    fun deleteMovieFromWatchlist(movieId: Int) {
        deleteWatchlistItemUseCase.deleteWatchlistItem(getWatchlistItem(movieId))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _showItemDeletedToastMessage.value = true
            }
    }

    private fun getWatchlistItem(movieId: Int) = WatchlistItem(
        movieId,
        _movieDetail.value?.originalTitle.orEmpty(),
        MediaType.MOVIE
    )

    fun doneShowingItemAddedToast() {
        _showItemAddedToastMessage.value = false
    }

    fun doneShowingItemDeletedToast() {
        _showItemDeletedToastMessage.value = false
    }
}
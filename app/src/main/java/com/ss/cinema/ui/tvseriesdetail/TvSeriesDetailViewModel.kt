package com.ss.cinema.ui.tvseriesdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.domain.model.TvSeriesDetail
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.domain.usecase.CheckIfItemIsInWatchlistUseCase
import com.ss.cinema.domain.usecase.DeleteWatchlistItemUseCase
import com.ss.cinema.domain.usecase.FetchTvSeriesDetailUseCase
import com.ss.cinema.domain.usecase.InsertItemToWatchlistUseCase
import com.ss.cinema.util.mediatype.MediaType
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TvSeriesDetailViewModel @Inject constructor(
    private val fetchTvSeriesDetailUseCase: FetchTvSeriesDetailUseCase,
    private val checkIfItemIsInWatchlistUseCase: CheckIfItemIsInWatchlistUseCase,
    private val insertItemToWatchlistUseCase: InsertItemToWatchlistUseCase,
    private val deleteWatchlistItemUseCase: DeleteWatchlistItemUseCase
) : ViewModel() {

    private val _tvSeriesDetail = MutableLiveData<TvSeriesDetail>()
    val tvSeriesDetail: LiveData<TvSeriesDetail>
        get() = _tvSeriesDetail

    private val _showItemAddedToastMessage = MutableLiveData<Boolean>()
    val showItemAddedToastMessage: LiveData<Boolean>
        get() = _showItemAddedToastMessage

    private val _showItemDeletedToastMessage = MutableLiveData<Boolean>()
    val showItemDeletedToastMessage: LiveData<Boolean>
        get() = _showItemDeletedToastMessage

    private val _isTvSeriesInWatchlist = MutableLiveData<Boolean>()
    val isTvSeriesInWatchlist: LiveData<Boolean>
        get() = _isTvSeriesInWatchlist

    fun fetchTvSeriesDetail(tvSeriesId: Int) {
        fetchTvSeriesDetailUseCase.fetchTvSeriesDetail(tvSeriesId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resource ->
                if (resource is Resource.Success) {
                    resource.map {
                        _tvSeriesDetail.value = it
                    }
                }
            }
    }

    fun checkIfTvSeriesIsInWatchlist(tvSeriesId: Int) {
        checkIfItemIsInWatchlistUseCase.checkIfItemIsInWatchlist("TV$tvSeriesId")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it?.let {
                    _isTvSeriesInWatchlist.value = true
                }
            }
    }

    fun insertTvSeriesToWatchlist(movieId: Int) {
        insertItemToWatchlistUseCase.insertItemToWatchlist(getWatchlistItem(movieId))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _showItemAddedToastMessage.value = true
            }
    }

    fun deleteTvSeriesFromWatchlist(movieId: Int) {
        deleteWatchlistItemUseCase.deleteWatchlistItem(getWatchlistItem(movieId))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _showItemDeletedToastMessage.value = true
            }
    }

    private fun getWatchlistItem(movieId: Int) = WatchlistItem(
        "TV$movieId",
        _tvSeriesDetail.value?.originalName.orEmpty(),
        MediaType.TV,
        Calendar.getInstance().time
    )

    fun doneShowingItemAddedToast() {
        _showItemAddedToastMessage.value = false
    }

    fun doneShowingItemDeletedToast() {
        _showItemDeletedToastMessage.value = false
    }
}
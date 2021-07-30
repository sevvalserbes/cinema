package com.ss.cinema.ui.watchlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.domain.usecase.DeleteWatchlistItemsUseCase
import com.ss.cinema.domain.usecase.FetchWatchlistItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val fetchWatchlistItemsUseCase: FetchWatchlistItemsUseCase,
    private val deleteWatchlistItemsUseCase: DeleteWatchlistItemsUseCase
) : ViewModel() {

    init {
        fetchWatchlistItems()
    }

    private val _watchlistItems = MutableLiveData<List<WatchlistItem>>()
    val watchlistItems: LiveData<List<WatchlistItem>>
        get() = _watchlistItems

    private fun fetchWatchlistItems() {
        fetchWatchlistItemsUseCase.fetchWatchlistItems()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _watchlistItems.value = it
            }
    }

    fun clearWatchlist() {
        deleteWatchlistItemsUseCase.clearWatchlist()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun deleteWatchlistItem(watchlistItem: WatchlistItem) {
        deleteWatchlistItemsUseCase.deleteWatchlistItem(watchlistItem)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}
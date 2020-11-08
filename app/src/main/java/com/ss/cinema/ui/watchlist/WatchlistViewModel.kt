package com.ss.cinema.ui.watchlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.domain.usecase.FetchWatchlistItemsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class WatchlistViewModel @ViewModelInject constructor(
    private val fetchWatchlistItemsUseCase: FetchWatchlistItemsUseCase
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
}
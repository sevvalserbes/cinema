package com.ss.cinema.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.domain.model.MultiSearch
import com.ss.cinema.domain.usecase.FetchMultiSearchResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val fetchMultiSearchResultUseCase: FetchMultiSearchResultUseCase
) : ViewModel() {

    private val _searchResult = MutableLiveData<List<MultiSearch>>()
    val searchResult: LiveData<List<MultiSearch>>
        get() = _searchResult

    fun fetchMultiSearchResult(queryValue: String) {
        fetchMultiSearchResultUseCase.fetchSearchResult(queryValue)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resource ->
                if (resource is Resource.Success) {
                    resource.map {
                        _searchResult.value = it
                    }
                }
            }
    }

    fun onSearchViewCloseIconClick() {
        _searchResult.value = listOf()
    }
}
package com.ss.cinema.ui.tvseriesdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ss.cinema.data.Resource
import com.ss.cinema.data.map
import com.ss.cinema.domain.model.TvSeriesDetail
import com.ss.cinema.domain.usecase.FetchTvSeriesDetailUseCase
import com.ss.cinema.util.ReactiveViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class TvSeriesDetailViewModel @ViewModelInject constructor(
    private val fetchTvSeriesDetailUseCase: FetchTvSeriesDetailUseCase
) : ReactiveViewModel() {
    private val _tvSeriesDetail = MutableLiveData<TvSeriesDetail>()
    val tvSeriesDetail: LiveData<TvSeriesDetail>
        get() = _tvSeriesDetail

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
            }.also {
                disposable.add(it)
            }
    }
}
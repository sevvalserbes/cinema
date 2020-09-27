package com.ss.cinema.ui.tvseries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ss.cinema.databinding.ListItemTvSeriesBinding
import com.ss.cinema.domain.model.TvSeries
import com.ss.cinema.domain.viewstate.TvSeriesViewState
import javax.inject.Inject

class TvSeriesAdapter @Inject constructor() :
    ListAdapter<TvSeries, TvSeriesAdapter.TvSeriesViewHolder>(TvSeriesDiffCallback()) {

    private lateinit var tvSeriesHandler: TvSeriesHandler

    fun setTvSeriesHandler(handler: TvSeriesHandler) {
        tvSeriesHandler = handler
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvSeriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemTvSeriesBinding.inflate(layoutInflater, parent, false)
        return TvSeriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvSeriesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, tvSeriesHandler)
    }

    class TvSeriesViewHolder(private val binding: ListItemTvSeriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TvSeries, tvSeriesHandler: TvSeriesHandler) {
            with(binding) {
                viewState = TvSeriesViewState(item)
                handler = tvSeriesHandler
                executePendingBindings()
            }
        }
    }

    class TvSeriesDiffCallback : DiffUtil.ItemCallback<TvSeries>() {

        override fun areItemsTheSame(oldItem: TvSeries, newItem: TvSeries): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvSeries, newItem: TvSeries): Boolean {
            return oldItem == newItem
        }
    }
}
package com.ss.cinema.ui.watchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ss.cinema.databinding.ListItemWatchlistBinding
import com.ss.cinema.domain.model.WatchlistItem
import com.ss.cinema.domain.viewstate.WatchlistViewState
import javax.inject.Inject

class WatchlistAdapter @Inject constructor() :
    ListAdapter<WatchlistItem, WatchlistAdapter.WatchlistItemViewHolder>(WatchlistDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemWatchlistBinding.inflate(layoutInflater, parent, false)
        return WatchlistItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WatchlistItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class WatchlistItemViewHolder(private val binding: ListItemWatchlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WatchlistItem) {
            with(binding) {
                viewState = WatchlistViewState(item)
                executePendingBindings()
            }
        }
    }

    class WatchlistDiffCallback : DiffUtil.ItemCallback<WatchlistItem>() {
        override fun areItemsTheSame(oldItem: WatchlistItem, newItem: WatchlistItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: WatchlistItem, newItem: WatchlistItem): Boolean {
            return oldItem == newItem
        }
    }
}
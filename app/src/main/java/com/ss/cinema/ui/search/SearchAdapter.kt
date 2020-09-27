package com.ss.cinema.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ss.cinema.databinding.ListItemSearchBinding
import com.ss.cinema.domain.model.MultiSearch
import com.ss.cinema.domain.viewbinding.SearchViewBinding
import javax.inject.Inject

class SearchAdapter @Inject constructor() :
    ListAdapter<MultiSearch, SearchAdapter.MultiSearchViewHolder>(MultiSearchDiffCallback()) {

    private lateinit var searchHandler: SearchHandler

    fun setSearchHandler(handler: SearchHandler) {
        searchHandler = handler
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiSearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemSearchBinding.inflate(layoutInflater, parent, false)
        return MultiSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MultiSearchViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, searchHandler)
    }

    class MultiSearchViewHolder(private val binding: ListItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MultiSearch, searchHandler: SearchHandler) {
            with(binding) {
                viewBinding = SearchViewBinding(item)
                handler = searchHandler
                executePendingBindings()
            }
        }
    }

    class MultiSearchDiffCallback : DiffUtil.ItemCallback<MultiSearch>() {

        override fun areItemsTheSame(oldItem: MultiSearch, newItem: MultiSearch): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MultiSearch, newItem: MultiSearch): Boolean {
            return oldItem == newItem
        }
    }
}
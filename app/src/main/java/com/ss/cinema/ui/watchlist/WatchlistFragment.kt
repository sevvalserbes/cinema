package com.ss.cinema.ui.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ss.cinema.R
import com.ss.cinema.databinding.FragmentWatchlistBinding
import com.ss.cinema.domain.viewstate.WatchlistViewState
import com.ss.cinema.util.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WatchlistFragment : Fragment() {

    @Inject
    lateinit var watchlistAdapter: WatchlistAdapter

    private lateinit var binding: FragmentWatchlistBinding
    private val viewModel by viewModels<WatchlistViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWatchlistBinding.inflate(inflater)
        val view = binding.root
        initWatchlistAdapter()
        subscribeUi()
        initClearButtonOnClick()
        return view
    }

    private fun initWatchlistAdapter() {
        binding.recyclerViewWatchlist.apply {
            adapter = watchlistAdapter
        }
        val itemTouchHelperCallback = object :
            ItemTouchHelper.SimpleCallback(
                0,
                LEFT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.deleteWatchlistItem(watchlistAdapter.currentList[viewHolder.adapterPosition])
                context?.showToast(getString(R.string.removed_from_watchlist), Toast.LENGTH_SHORT)
            }

        }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerViewWatchlist)
    }

    private fun subscribeUi() {
        viewModel.watchlistItems.observe(viewLifecycleOwner) { watchlistItems ->
            binding.viewState = WatchlistViewState(watchlistItems.size)
            watchlistAdapter.submitList(watchlistItems)
        }
    }

    private fun initClearButtonOnClick() {
        with(binding.buttonWatchlistClear) {
            setOnClickListener {
                viewModel.clearWatchlist()
            }
        }
    }
}
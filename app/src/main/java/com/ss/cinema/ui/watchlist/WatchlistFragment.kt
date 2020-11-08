package com.ss.cinema.ui.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ss.cinema.databinding.FragmentWatchlistBinding
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
    ): View? {
        binding = FragmentWatchlistBinding.inflate(inflater)
        val view = binding.root
        initWatchlistAdapter()
        subscribeUi()
        return view
    }

    private fun initWatchlistAdapter() {
        binding.recyclerViewWatchlist.apply {
            adapter = watchlistAdapter
        }
    }

    private fun subscribeUi() {
        viewModel.watchlistItems.observe(viewLifecycleOwner) { watchlistItems ->
            watchlistAdapter.submitList(watchlistItems)
        }
    }
}
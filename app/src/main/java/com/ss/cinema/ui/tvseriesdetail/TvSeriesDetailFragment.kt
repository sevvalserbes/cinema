package com.ss.cinema.ui.tvseriesdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ss.cinema.R
import com.ss.cinema.databinding.FragmentTvSeriesDetailBinding
import com.ss.cinema.domain.viewstate.TvSeriesDetailViewState
import com.ss.cinema.util.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvSeriesDetailFragment : Fragment() {

    private val viewModel by viewModels<TvSeriesDetailViewModel>()

    private val args: TvSeriesDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentTvSeriesDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvSeriesDetailBinding.inflate(inflater)
        checkIfTvSeriesIsInWatchlist()
        fetchTvSeriesDetail()
        subscribeUi()
        initCheckBoxOnClick()
        observeItemAddedToastMessage()
        observeItemDeletedToastMessage()
        return binding.root
    }

    private fun checkIfTvSeriesIsInWatchlist() {
        viewModel.checkIfTvSeriesIsInWatchlist(args.tvSeriesId)
    }

    private fun fetchTvSeriesDetail() {
        viewModel.fetchTvSeriesDetail(args.tvSeriesId)
    }

    private fun subscribeUi() {
        viewModel.tvSeriesDetail.observe(viewLifecycleOwner) {
            binding.viewState = TvSeriesDetailViewState(it)
        }

        viewModel.isTvSeriesInWatchlist.observe(viewLifecycleOwner) {
            if (it == true) {
                binding.checkboxTvSeriesDetail.isChecked = true
            }
        }
    }

    private fun initCheckBoxOnClick() {
        with(binding.checkboxTvSeriesDetail) {
            setOnClickListener {
                if (this.isChecked) {
                    viewModel.insertTvSeriesToWatchlist(args.tvSeriesId)
                } else {
                    viewModel.deleteTvSeriesFromWatchlist(args.tvSeriesId)
                }
            }
        }
    }

    private fun observeItemAddedToastMessage() {
        viewModel.showItemAddedToastMessage.observe(viewLifecycleOwner) {
            if (it == true) {
                context?.showToast(getString(R.string.added_to_watchlist), Toast.LENGTH_SHORT)
                viewModel.doneShowingItemAddedToast()
            }
        }
    }

    private fun observeItemDeletedToastMessage() {
        viewModel.showItemDeletedToastMessage.observe(viewLifecycleOwner) {
            if (it == true) {
                context?.showToast(getString(R.string.removed_from_watchlist), Toast.LENGTH_SHORT)
                viewModel.doneShowingItemDeletedToast()
            }
        }
    }
}
package com.ss.cinema.ui.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ss.cinema.R
import com.ss.cinema.databinding.FragmentMovieDetailBinding
import com.ss.cinema.domain.viewstate.MovieDetailViewState
import com.ss.cinema.util.extensions.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private val viewModel by viewModels<MovieDetailViewModel>()

    private val args: MovieDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater)
        checkIfMovieIsInWatchlist()
        fetchMovieDetail()
        subscribeUi()
        initCheckBoxOnClick()
        observeItemAddedToastMessage()
        observeItemDeletedToastMessage()
        return binding.root
    }

    private fun checkIfMovieIsInWatchlist() {
        viewModel.checkIfMovieIsInWatchlist(args.movieId)
    }

    private fun fetchMovieDetail() {
        viewModel.fetchMovieDetail(args.movieId)
    }

    private fun subscribeUi() {
        viewModel.movieDetail.observe(viewLifecycleOwner) {
            binding.viewState = MovieDetailViewState(it)
        }

        viewModel.isMovieInWatchlist.observe(viewLifecycleOwner) {
            if (it == true) {
                binding.checkboxMovieDetail.isChecked = true
            }
        }
    }

    private fun initCheckBoxOnClick() {
        with(binding.checkboxMovieDetail) {
            setOnClickListener {
                if (this.isChecked) {
                    viewModel.insertMovieToWatchlist(args.movieId)
                } else {
                    viewModel.deleteMovieFromWatchlist(args.movieId)
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
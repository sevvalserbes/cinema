package com.ss.cinema.ui.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ss.cinema.databinding.FragmentMovieDetailBinding
import com.ss.cinema.domain.viewstate.MovieDetailViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    companion object {
        fun newInstance() = MovieDetailFragment()
    }

    private val viewModel by viewModels<MovieDetailViewModel>()

    private val args: MovieDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater)
        fetchMovieDetail()
        subscribeUi()
        return binding.root
    }

    private fun fetchMovieDetail() {
        viewModel.fetchMovieDetail(args.movieId)
    }

    private fun subscribeUi() {
        viewModel.movieDetail.observe(viewLifecycleOwner) {
            binding.viewState = MovieDetailViewState(it)
        }
    }
}
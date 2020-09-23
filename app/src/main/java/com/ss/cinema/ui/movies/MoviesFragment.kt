package com.ss.cinema.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ss.cinema.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    companion object {
        fun newInstance(): MoviesFragment = MoviesFragment()
    }

    private val viewModel by viewModels<MoviesViewModel>()

    private lateinit var binding: FragmentMoviesBinding

    @Inject
    lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater)
        val view = binding.root
        initPopularMovieAdapter()
        subscribeUi()
        return view
    }

    private fun initPopularMovieAdapter() {
        binding.recyclerViewMovies.apply {
            adapter = movieAdapter
        }
    }

    private fun subscribeUi() {
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            movieAdapter.setData(movies)
        }
    }
}
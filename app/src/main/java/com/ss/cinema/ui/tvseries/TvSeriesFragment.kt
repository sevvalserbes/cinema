package com.ss.cinema.ui.tvseries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ss.cinema.databinding.FragmentTvSeriesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvSeriesFragment : Fragment(), TvSeriesHandler {

    @Inject
    lateinit var tvSeriesAdapter: TvSeriesAdapter

    private lateinit var binding: FragmentTvSeriesBinding
    private val viewModel by viewModels<TvSeriesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvSeriesBinding.inflate(inflater)
        val view = binding.root
        initPopularTvSeriesAdapter()
        subscribeUi()
        return view
    }

    private fun initPopularTvSeriesAdapter() {
        tvSeriesAdapter.setTvSeriesHandler(this)
        binding.recyclerViewTvSeries.apply {
            adapter = tvSeriesAdapter
        }
    }

    private fun subscribeUi() {
        viewModel.tvSeries.observe(viewLifecycleOwner) { tvSeries ->
            tvSeriesAdapter.submitList(tvSeries)
        }
    }

    override fun onTvSeriesClick(tvSeriesId: Int) {
        val directions =
            TvSeriesFragmentDirections.actionTvSeriesFragmentToTvSeriesDetailFragment(tvSeriesId)
        findNavController().navigate(directions)
    }
}
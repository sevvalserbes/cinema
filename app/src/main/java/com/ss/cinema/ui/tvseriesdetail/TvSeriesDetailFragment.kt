package com.ss.cinema.ui.tvseriesdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ss.cinema.databinding.FragmentTvSeriesDetailBinding
import com.ss.cinema.domain.viewbinding.TvSeriesDetailViewBinding
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
    ): View? {
        binding = FragmentTvSeriesDetailBinding.inflate(inflater)
        fetchTvSeriesDetail()
        subscribeUi()
        return binding.root
    }

    private fun fetchTvSeriesDetail() {
        viewModel.fetchTvSeriesDetail(args.tvSeriesId)
    }

    private fun subscribeUi() {
        viewModel.tvSeriesDetail.observe(viewLifecycleOwner) {
            binding.viewBinding = TvSeriesDetailViewBinding(it)
        }
    }
}
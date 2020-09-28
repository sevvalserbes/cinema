package com.ss.cinema.ui.tvseriesdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ss.cinema.databinding.FragmentTvSeriesDetailBinding
import com.ss.cinema.domain.viewstate.TvSeriesDetailViewState
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
        initCheckBoxOnClick()
        return binding.root
    }

    private fun fetchTvSeriesDetail() {
        viewModel.fetchTvSeriesDetail(args.tvSeriesId)
    }

    private fun subscribeUi() {
        viewModel.tvSeriesDetail.observe(viewLifecycleOwner) {
            binding.viewState = TvSeriesDetailViewState(it)
        }
    }

    private fun initCheckBoxOnClick() {
        with(binding.checkboxTvSeriesDetail) {
            setOnClickListener {
                if (this.isChecked) {
                    Toast.makeText(
                        context,
                        "Added to the watchlist!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
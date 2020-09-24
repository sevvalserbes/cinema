package com.ss.cinema.ui.tvseries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ss.cinema.databinding.FragmentTvSeriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvSeriesFragment : Fragment() {
    companion object {
        fun newInstance() = TvSeriesFragment()
    }

    private lateinit var binding: FragmentTvSeriesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvSeriesBinding.inflate(inflater)
        val view = binding.root
        return view
    }
}
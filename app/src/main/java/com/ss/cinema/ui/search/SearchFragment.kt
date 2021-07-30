package com.ss.cinema.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ss.cinema.databinding.FragmentSearchBinding
import com.ss.cinema.util.mediatype.MediaType
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment(), SearchHandler {

    @Inject
    lateinit var searchAdapter: SearchAdapter

    private lateinit var binding: FragmentSearchBinding
    private val viewModel by viewModels<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)
        val view = binding.root
        initSearchViewOnQueryListener()
        initSearchViewOnCloseListener()
        initSearchAdapter()
        subscribeUi()
        return view
    }

    private fun initSearchViewOnQueryListener() {
        Observable
            .create(ObservableOnSubscribe<String> { subscriber ->
                binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        subscriber.onNext(query)
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        subscriber.onNext(newText)
                        return false
                    }
                })
            })
            .map { queryValue ->
                queryValue.lowercase().trim()
            }
            .debounce(250, TimeUnit.MILLISECONDS)
            .filter { queryValue -> queryValue.length > 2 }
            .subscribe { queryValue ->
                viewModel.fetchMultiSearchResult(queryValue)
            }
    }

    private fun initSearchViewOnCloseListener() {
        binding.searchView.setOnCloseListener {
            viewModel.onSearchViewCloseIconClick()
            false
        }
    }

    private fun initSearchAdapter() {
        searchAdapter.setSearchHandler(this)
        binding.recyclerViewSearchItems.apply {
            adapter = searchAdapter
        }
    }

    private fun subscribeUi() {
        viewModel.searchResult.observe(viewLifecycleOwner) { searchResult ->
            searchAdapter.submitList(searchResult)
        }
    }

    override fun onSearchItemClick(itemId: Int, mediaType: MediaType) {
        when (mediaType) {
            MediaType.MOVIE -> {
                val directions =
                    SearchFragmentDirections.actionSearchFragmentToMovieDetailFragment(itemId)
                findNavController().navigate(directions)
            }
            MediaType.TV -> {
                val directions =
                    SearchFragmentDirections.actionSearchFragmentToTvSeriesDetailFragment(itemId)
                findNavController().navigate(directions)
            }
            else -> return
        }
    }
}
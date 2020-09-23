package com.ss.cinema.ui.movies

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ss.cinema.R
import com.ss.cinema.databinding.ItemMovieBinding
import com.ss.cinema.domain.model.Movie
import com.ss.cinema.domain.viewbinding.MovieViewBinding
import com.ss.cinema.util.BaseViewHolder
import com.ss.cinema.util.extensions.inflate
import javax.inject.Inject

class MovieAdapter @Inject constructor() : RecyclerView.Adapter<BaseViewHolder<Movie>>() {

    private var movies: List<Movie> = listOf()

    fun setData(data: List<Movie>) {
        this.movies = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Movie> {
        val binding = parent.inflate<ItemMovieBinding>(
            R.layout.item_movie,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Movie>, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class MovieViewHolder(private val binding: ItemMovieBinding) :
        BaseViewHolder<Movie>(binding.root) {
        override fun bind(item: Movie) {
            with(binding) {
                viewBinding = MovieViewBinding(item)
            }
        }
    }
}
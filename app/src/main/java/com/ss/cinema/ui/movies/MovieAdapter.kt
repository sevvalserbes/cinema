package com.ss.cinema.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ss.cinema.databinding.ListItemMovieBinding
import com.ss.cinema.domain.model.Movie
import com.ss.cinema.domain.viewbinding.MovieViewBinding
import javax.inject.Inject

class MovieAdapter @Inject constructor() :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(MovieDiffCallback()) {

    private lateinit var movieHandler: MovieHandler

    fun setMovieHandler(handler: MovieHandler) {
        movieHandler = handler
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemMovieBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, movieHandler)
    }

    class MovieViewHolder(private val binding: ListItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie, movieHandler: MovieHandler) {
            with(binding) {
                viewBinding = MovieViewBinding(item)
                handler = movieHandler
                executePendingBindings()
            }
        }
    }

    class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}
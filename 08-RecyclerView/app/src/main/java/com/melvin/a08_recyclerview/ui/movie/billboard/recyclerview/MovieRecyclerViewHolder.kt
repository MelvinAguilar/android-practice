package com.melvin.a08_recyclerview.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.melvin.a08_recyclerview.data.model.MovieModel
import com.melvin.a08_recyclerview.databinding.ItemMovieBinding

class MovieRecyclerViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder (binding.root) {
    fun bind (movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.movieName.text = movie.name
        binding.movieQualification.text = movie.qualification
        binding.movieCardView.setOnClickListener { clickListener(movie) }
    }
}
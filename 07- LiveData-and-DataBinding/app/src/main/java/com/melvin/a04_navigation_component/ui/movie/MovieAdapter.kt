package com.melvin.a04_navigation_component.ui.movie


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.melvin.a04_navigation_component.R
import com.melvin.a04_navigation_component.data.model.MovieModel

class MovieAdapter(private val onClickMovie: (MovieModel) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolderMovie>() {

    private var movies: List<MovieModel>? = null

    class ViewHolderMovie(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: MovieModel, onClickMovie: (MovieModel) -> Unit) {

            val nameTextView = itemView.findViewById<TextView>(R.id.movie_name)
            nameTextView.text = movie.name
            val qualificationTextView = itemView.findViewById<TextView>(R.id.movie_qualification)
            qualificationTextView.text = movie.qualification

            nameTextView.setOnClickListener {
                onClickMovie(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater
            .inflate(
                R.layout.item_movie, parent,
                false
            )
        return ViewHolderMovie(view)
    }

    override fun getItemCount(): Int = movies?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        movies?.let {
            holder.bind(it[position], onClickMovie)
        }
    }

    fun submitData(movies: MutableList<MovieModel>) {
        this.movies = movies
        notifyDataSetChanged()
    }

}
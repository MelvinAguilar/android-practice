package com.melvin.a08_recyclerview.ui.movie.billboard.recyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.melvin.a08_recyclerview.R
import com.melvin.a08_recyclerview.data.model.MovieModel
import com.melvin.a08_recyclerview.databinding.ItemMovieBinding

class MovieRecyclerViewAdapter(private val onClickMovie: (MovieModel) -> Unit) :
    RecyclerView.Adapter<MovieRecyclerViewHolder>() {

//    private var movies: List<MovieModel>? = null
    private val movies = ArrayList<MovieModel>()

//    class ViewHolderMovie(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bind(movie: MovieModel, onClickMovie: (MovieModel) -> Unit) {
//            val nameTextView = itemView.findViewById<TextView>(R.id.movie_name)
//            nameTextView.text = movie.name
//            val qualificationTextView = itemView.findViewById<TextView>(R.id.movie_qualification)
//            qualificationTextView.text = movie.qualification
//
//            nameTextView.setOnClickListener {
//                onClickMovie(movie)
//            }
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = movies?.size ?: 0

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
//        movies?.let {
//            holder.bind(it[position], onClickMovie)
//        }
        val movie = movies[position]
        holder.bind(movie, onClickMovie)
    }

    fun setData(movieList: List<MovieModel>){
        movies.clear()
        movies.addAll(movieList)
    }
}
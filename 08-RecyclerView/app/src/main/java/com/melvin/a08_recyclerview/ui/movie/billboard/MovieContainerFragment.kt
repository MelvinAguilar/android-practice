package com.melvin.a08_recyclerview.ui.movie.billboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.melvin.a08_recyclerview.R
import com.melvin.a08_recyclerview.data.model.MovieModel
import com.melvin.a08_recyclerview.databinding.FragmentMovieContainerBinding
import com.melvin.a08_recyclerview.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.melvin.a08_recyclerview.ui.movie.newmovie.FormAddMovieFragment
import com.melvin.a08_recyclerview.ui.movie.viewmodel.MovieViewModel

class MovieContainerFragment : Fragment() {
    private lateinit var newMovieButton: FloatingActionButton
    private lateinit var binding: FragmentMovieContainerBinding
    private lateinit var adapter: MovieRecyclerViewAdapter

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_container, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        bind()
        addListeners()
    }

    private fun setRecyclerView(view: View) {
        adapter = MovieRecyclerViewAdapter { movie ->
            showSelectedItem(movie)
        }

        binding.recyclerMovies.adapter = adapter
        displayMovies()
    }

    private fun bind() {
        newMovieButton = view?.findViewById(R.id.add_new_movie_action) as FloatingActionButton
    }

    private fun addListeners() {
        newMovieButton.setOnClickListener {
            viewModel.clearData()
            it.findNavController()
                .navigate(R.id.action_movieContainerFragment_to_formAddMovieFragment)
        }
    }

    private fun showSelectedItem(movie: MovieModel) {
        viewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_movieContainerFragment_to_movieDetailFragment)
    }

    private fun displayMovies() {
        adapter.setData(viewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

}
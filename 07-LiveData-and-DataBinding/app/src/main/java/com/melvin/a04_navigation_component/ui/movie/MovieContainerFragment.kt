package com.melvin.a04_navigation_component.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.melvin.a04_navigation_component.R
import com.melvin.a04_navigation_component.databinding.FragmentMovieContainerBinding

class MovieContainerFragment : Fragment() {
    private lateinit var newMovieButton: FloatingActionButton

    private lateinit var binding: FragmentMovieContainerBinding
    private val viewModel: MovieViewModel by viewModels {
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

        val adapter = MovieAdapter { movie ->
            Toast.makeText(
                requireContext(), "Clic en ${movie.description} ", Toast.LENGTH_LONG
            ).show()
        }

        adapter.submitData(viewModel.getMovies())
        binding.recyclerMovies.adapter = adapter

        bind()
        addListeners()
    }

    private fun bind() {
        newMovieButton = view?.findViewById(R.id.add_new_movie_action) as FloatingActionButton
    }

    private fun addListeners() {
        newMovieButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_movieContainerFragment_to_formAddMovieFragment)
        }
    }

}
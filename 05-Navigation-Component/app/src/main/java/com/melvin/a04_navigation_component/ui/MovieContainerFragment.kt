package com.melvin.a04_navigation_component.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.melvin.a04_navigation_component.R

class MovieContainerFragment : Fragment() {
    private lateinit var newMovieButton: FloatingActionButton
    private lateinit var movieDetailCard: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        addListeners()
    }

    private fun bind() {
        newMovieButton = view?.findViewById(R.id.add_new_movie_action) as FloatingActionButton
        movieDetailCard = view?.findViewById(R.id.star_wars_card_view) as CardView
    }

    private fun addListeners() {
        newMovieButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_movieContainerFragment_to_formAddMovieFragment)
        }

        movieDetailCard.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_movieContainerFragment_to_movieDetailFragment)
        }
    }

}
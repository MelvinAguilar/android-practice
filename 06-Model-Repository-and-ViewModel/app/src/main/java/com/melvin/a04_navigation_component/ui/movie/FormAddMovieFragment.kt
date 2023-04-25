package com.melvin.a04_navigation_component.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.addCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.melvin.a04_navigation_component.R
import com.melvin.a04_navigation_component.data.model.MovieModel
import com.melvin.a04_navigation_component.data.movies
import com.melvin.a04_navigation_component.repositories.MovieRepository

class FormAddMovieFragment : Fragment() {
    private lateinit var returnButton: FloatingActionButton

    private lateinit var nameInput: TextInputEditText
    private lateinit var categoryInput: TextInputEditText
    private lateinit var descriptionInput: TextInputEditText
    private lateinit var qualificationInput: TextInputEditText

    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form_add_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        addListeners()
    }

    private fun bind() {
        returnButton = view?.findViewById(R.id.return_button_form) as FloatingActionButton

        nameInput = view?.findViewById(R.id.name_text_input) as TextInputEditText
        categoryInput = view?.findViewById(R.id.category_text_input) as TextInputEditText
        descriptionInput = view?.findViewById(R.id.description_text_view) as TextInputEditText
        qualificationInput = view?.findViewById(R.id.qualification_text_view) as TextInputEditText


        submitButton = view?.findViewById(R.id.submit_button) as Button
    }

    private fun addListeners() {
        returnButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_formAddMovieFragment_to_movieContainerFragment)
        }

        submitButton.setOnClickListener {
            saveData()
            it.findNavController()
                .navigate(R.id.action_formAddMovieFragment_to_movieContainerFragment);
        }
    }


    private fun saveData() {
        val newMovie = MovieModel(
            nameInput.text.toString(),
            categoryInput.text.toString(),
            descriptionInput.text.toString(),
            qualificationInput.text.toString()
        )

        MovieRepository(movies).addMovies(newMovie)
    }
}
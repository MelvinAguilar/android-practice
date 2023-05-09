package com.melvin.a08_recyclerview.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.melvin.a08_recyclerview.R
import com.melvin.a08_recyclerview.databinding.FragmentFormAddMovieBinding
import com.melvin.a08_recyclerview.ui.movie.viewmodel.MovieViewModel

class FormAddMovieFragment : Fragment() {
    private lateinit var binding: FragmentFormAddMovieBinding

    private lateinit var returnButton: FloatingActionButton
    private lateinit var nameInput: TextInputEditText
    private lateinit var categoryInput: TextInputEditText
    private lateinit var descriptionInput: TextInputEditText
    private lateinit var qualificationInput: TextInputEditText
    private lateinit var submitButton: Button

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_form_add_movie, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        addListeners()
        setViewModel()
        observeStatus()
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
            findNavController().popBackStack()
        }
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    Toast.makeText(
                        requireContext(), "Wrong information", Toast.LENGTH_LONG
                    ).show()
                    viewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, viewModel.getMovies().toString())

                    Toast.makeText(
                        requireContext(), "Movie created", Toast.LENGTH_LONG
                    ).show()
                    viewModel.clearStatus()

                    findNavController()
                        .navigate(R.id.action_formAddMovieFragment_to_movieContainerFragment)
                }
            }
        }
    }

    companion object {
        private const val APP_TAG = "MyActivity"
    }
}
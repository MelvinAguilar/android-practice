package com.melvin.a08_recyclerview.ui.movie


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.melvin.a08_recyclerview.R
import com.melvin.a08_recyclerview.databinding.FragmentMovieDetailBinding
import com.melvin.a08_recyclerview.ui.movie.viewmodel.MovieViewModel

class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding

    private lateinit var returnButton: FloatingActionButton

    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()

        bind()
        addListeners()

        Log.d("MyActivity", "Name in onViewCreated(): " + viewModel.name.value)
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun bind() {
        returnButton = view?.findViewById(R.id.return_to_billboard_button) as FloatingActionButton
    }

    private fun addListeners() {
        returnButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}
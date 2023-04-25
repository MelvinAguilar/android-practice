package com.melvin.a04_navigation_component.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.melvin.a04_navigation_component.MovieReviewerApplication
import com.melvin.a04_navigation_component.data.model.MovieModel
import com.melvin.a04_navigation_component.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    fun getMovies() = repository.getMovies()

    fun addMovies(movie: MovieModel) = repository.addMovies(movie)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val movieRepository = (this[APPLICATION_KEY] as MovieReviewerApplication).movieRepository
                MovieViewModel(movieRepository)
            }
        }
    }
}
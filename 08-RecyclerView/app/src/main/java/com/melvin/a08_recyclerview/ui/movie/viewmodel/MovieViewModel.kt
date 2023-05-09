package com.melvin.a08_recyclerview.ui.movie.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.melvin.a08_recyclerview.MovieReviewerApplication
import com.melvin.a08_recyclerview.data.model.MovieModel
import com.melvin.a08_recyclerview.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMovies() = repository.getMovies()

    fun addMovies(movie: MovieModel) = repository.addMovies(movie)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val movieRepository = (this[APPLICATION_KEY] as MovieReviewerApplication).movieRepository
                MovieViewModel(movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

    fun createMovie() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val movie = MovieModel(
            name.value !!,
            category.value !!,
            description.value!!,
            qualification.value !!
        )

        addMovies(movie)
        clearData()

        status.value = MOVIE_CREATED
    }

    private fun validateData(): Boolean{
        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
        Log.d("MyActivity", " +++ Clear DATA +++ ")
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedMovie (movie: MovieModel) {
        name.value = movie.name
        category.value = movie.category
        description.value = movie.description
        qualification.value = movie.qualification
        Log.d("MyActivity", "Name in setSelectedMovie(): " + name.value)
    }
}
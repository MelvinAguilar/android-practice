package com.melvin.a04_navigation_component

import android.app.Application
import com.melvin.a04_navigation_component.data.movies
import com.melvin.a04_navigation_component.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}
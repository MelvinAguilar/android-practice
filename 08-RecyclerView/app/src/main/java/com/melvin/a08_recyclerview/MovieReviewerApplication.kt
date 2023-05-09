package com.melvin.a08_recyclerview

import android.app.Application
import com.melvin.a08_recyclerview.data.movies
import com.melvin.a08_recyclerview.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}
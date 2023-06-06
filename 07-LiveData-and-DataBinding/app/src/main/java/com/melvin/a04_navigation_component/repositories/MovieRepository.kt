package com.melvin.a04_navigation_component.repositories

import com.melvin.a04_navigation_component.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)
}
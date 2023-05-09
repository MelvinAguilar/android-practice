package com.melvin.a08_recyclerview.repositories

import com.melvin.a08_recyclerview.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)
}
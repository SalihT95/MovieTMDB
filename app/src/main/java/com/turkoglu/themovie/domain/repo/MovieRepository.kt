package com.turkoglu.themovie.domain.repo

import com.turkoglu.themovie.domain.model.Movie
import com.turkoglu.themovie.domain.model.MovieDetail

interface MovieRepository {
    suspend fun getMovies(page : Int) : List<Movie>

    suspend fun getMovie(movieId : Int) : MovieDetail
}
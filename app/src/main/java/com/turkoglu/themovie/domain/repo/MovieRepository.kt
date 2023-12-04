package com.turkoglu.themovie.domain.repo

import com.turkoglu.themovie.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies() : List<Movie>

    //suspend fun getMovieDetail(imdbId : String) : MovieDetailDto
}
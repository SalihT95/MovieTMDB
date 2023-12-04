package com.turkoglu.themovie.data.repo

import com.turkoglu.themovie.data.remote.MovieAPI
import com.turkoglu.themovie.domain.model.Movie
import com.turkoglu.themovie.domain.repo.MovieRepository
import com.turkoglu.themovie.util.toMovie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api :MovieAPI) :MovieRepository{
    override suspend fun getMovies(): List<Movie> {
        return api.getMovies().results.map {
            it.toMovie()
        }
    }
}
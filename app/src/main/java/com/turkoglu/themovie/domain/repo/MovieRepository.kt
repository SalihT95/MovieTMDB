package com.turkoglu.themovie.domain.repo

import com.turkoglu.themovie.data.remote.dto.DetailResponse
import com.turkoglu.themovie.data.remote.dto.PopularResponse
import com.turkoglu.themovie.domain.model.Movie
import com.turkoglu.themovie.domain.model.MovieDetail

interface MovieRepository {
    suspend fun getMovies(page : Int) : PopularResponse
    suspend fun getMovie(movieId : String) : DetailResponse
}
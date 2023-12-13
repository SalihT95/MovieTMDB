package com.turkoglu.themovie.data.repo

import com.turkoglu.themovie.common.Detail
import com.turkoglu.themovie.data.remote.MovieAPI
import com.turkoglu.themovie.data.remote.dto.DetailResponse
import com.turkoglu.themovie.data.remote.dto.PopularResponse
import com.turkoglu.themovie.domain.model.Movie
import com.turkoglu.themovie.domain.model.MovieDetail
import com.turkoglu.themovie.domain.repo.MovieRepository
import com.turkoglu.themovie.util.toMovie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api :MovieAPI) :MovieRepository{
    override suspend fun getMovies(page : Int): PopularResponse {
        return api.getMovies(page)
    }

    override suspend fun getMovie(movieId: Int): DetailResponse {
        return  api.getMovieDetails(movieId)
    }
}
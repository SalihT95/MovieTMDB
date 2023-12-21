package com.turkoglu.themovie.data.remote

import com.turkoglu.themovie.data.remote.dto.DetailResponse
import com.turkoglu.themovie.data.remote.dto.PopularResponse
import com.turkoglu.themovie.util.Constants.API_KEY
import com.turkoglu.themovie.util.Constants.STARTING_PAGE_INDEX
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {

    @GET("/movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): DetailResponse
    @GET("/movie/popular")
    suspend fun getMovies(
        @Query("page") page : Int  = STARTING_PAGE_INDEX ,
        @Query("api_key") apiKey: String = API_KEY
    ):PopularResponse



}
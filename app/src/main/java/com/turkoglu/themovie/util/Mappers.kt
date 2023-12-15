package com.turkoglu.themovie.util

import com.turkoglu.themovie.data.remote.dto.DetailResponse
import com.turkoglu.themovie.data.remote.dto.PopularResponse
import com.turkoglu.themovie.data.remote.dto.Result
import com.turkoglu.themovie.domain.model.Movie
import com.turkoglu.themovie.domain.model.MovieDetail
import com.turkoglu.themovie.util.Constants.IMAGE_BASE_URL

fun PopularResponse.toMovie() : List<Movie> {
    return  results.map {
        Movie(
            genreIds = it.genreIds,
            id = it.id,
            overview = it.overview,
            popularity  = it.popularity,
            imageUrl = getImageUrl(it.posterPath) ,
            releaseDate = it.releaseDate,
            title= it.title)
    }

}

private fun getImageUrl(posterImage : String) ="$IMAGE_BASE_URL$posterImage"

fun DetailResponse.toMovie() : MovieDetail {
    return MovieDetail(
        id = id,
        title= originalTitle,
        genres = genres,
        budget = budget,
        overview = overview,
        popularity  = popularity,
        imageUrl = getImageUrl(posterPath),
        releaseDate = releaseDate,
        voteAverage= voteAverage,
        voteCount = voteCount
    )
}

package com.turkoglu.themovie.util

import com.turkoglu.themovie.data.remote.dto.Result
import com.turkoglu.themovie.domain.model.Movie
import com.turkoglu.themovie.util.Constants.IMAGE_BASE_URL

fun Result.toMovie() : Movie {
    return Movie(
        genreIds = genreIds,
        id = id,
        overview = overview,
        popularity  = popularity,
        imageUrl = getImageUrl(posterPath) ,
        releaseDate = releaseDate,
        title= title
    )
}

private fun getImageUrl(posterImage : String) ="$IMAGE_BASE_URL$posterImage"
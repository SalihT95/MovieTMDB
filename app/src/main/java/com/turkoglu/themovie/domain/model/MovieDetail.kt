package com.turkoglu.themovie.domain.model

import com.google.gson.annotations.SerializedName
import com.turkoglu.themovie.data.remote.dto.Genre

data class MovieDetail (
    val id: Int,
    val title: String,
    val genres: List<Genre>,
    val budget: Int,
    val overview: String,
    val popularity: Double,
    val imageUrl: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int
)
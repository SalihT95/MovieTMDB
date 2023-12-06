package com.turkoglu.themovie.presentation.detail

import com.turkoglu.themovie.domain.model.MovieDetail

data class DetailScreenState(
    var loading: Boolean = false,
    var movie:  MovieDetail?=null,
    var errorMessage: String? = null
)
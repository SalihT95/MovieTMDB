package com.turkoglu.themovie.presentation.home

import com.turkoglu.themovie.domain.model.Movie

data class HomeScreenState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var movies: List<Movie>  = emptyList(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false
)
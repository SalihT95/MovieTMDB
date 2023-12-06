package com.turkoglu.themovie.presentation.home

import com.turkoglu.themovie.domain.model.Movie
import com.turkoglu.themovie.util.Resource
import kotlinx.coroutines.flow.Flow

data class HomeScreenState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var movies: List<Movie> = emptyList(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false
)
package com.turkoglu.themovie.presentation.detail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turkoglu.themovie.domain.use_case.get_movie.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
) :ViewModel() {
    var uiState by mutableStateOf(DetailScreenState())
    private var movieId: Int =123
    init {
        loadMovie(movieId)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun loadMovie(movieId: Int){
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
/*
            uiState = try {
                val movie = getMovieUseCase.executeGetMovie(movieId = movieId)
                uiState.copy(loading = false, movie = movie)
            }

*/

            try {
                val movie = getMovieUseCase.executeGetMovie(movieId = movieId)

                movie.let {movie ->

                    movie.map {
                        uiState = uiState.copy(
                            loading = false,
                            movie = it.data!!
                        )
                    }
                }
            } catch (error: Throwable){
                uiState.copy(
                    loading = false,
                    errorMessage = "Could not load the movie"
                )
            }
        }
    }
}


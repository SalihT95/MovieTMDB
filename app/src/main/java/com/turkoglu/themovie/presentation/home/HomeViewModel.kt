package com.turkoglu.themovie.presentation.home

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turkoglu.themovie.domain.model.Movie
import com.turkoglu.themovie.domain.use_case.get_movies.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1

    init {
        loadMovies(forceReload = false)
    }

    fun loadMovies(forceReload: Boolean = false) {
        if (uiState.loading) return
        if (forceReload) currentPage = 1
        if (currentPage == 1) uiState = uiState.copy(refreshing = true)


        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            try {
                val resultMovies = getMoviesUseCase.executeGetMovies(page = currentPage)


                resultMovies.map { ResourceMovieList ->
                    println("resultMoviesMap")
                    val movies= if (currentPage == 1) ResourceMovieList else uiState.movies + ResourceMovieList
                    currentPage += 1
                    println("loadingTryBefore : ${uiState.loading}")
                    uiState = uiState.copy(
                        loading = false,
                        refreshing = false,
                        loadFinished = true,
                        movies = movies
                    )

                    println("loadingTryAfter : ${uiState.loading}")
                }
                println("List ${uiState.movies}")
            } catch (error: Throwable) {
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    errorMessage = "Could not load : ${error.localizedMessage}"
                )
                println("loadingCatch : ${uiState.loading}")
            }

        }
    }
}
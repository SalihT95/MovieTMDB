package com.turkoglu.themovie.presentation.home

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turkoglu.themovie.domain.use_case.get_movies.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMovieUseCase
) : ViewModel() {

    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1


    fun loadMovies(forceReload : Boolean = false){

        if (uiState.loading) return

        if (forceReload) currentPage =1

        if (currentPage == 1) uiState = uiState.copy(refreshing = true)

        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            try {
                val resultMovies = getMoviesUseCase.executeGetMovies()
                var movies = resultMovies
                uiState.movies?.let {
                   if(currentPage !=1) {
                        movies=it + resultMovies
                    }

                }



                currentPage++

                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished =  true,
                    movies = movies

                )


            }catch (error : Throwable){
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    errorMessage = "Could not load : ${error.localizedMessage}"
                )
            }


        }

    }



}
package com.turkoglu.themovie.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.turkoglu.themovie.domain.model.Movie

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState : HomeScreenState,
    loadNextMovies : (Boolean) -> Unit,
    navigateToDetail : (Movie) -> Unit
) {



}
package com.turkoglu.themovie.presentation

sealed class Screen(val route : String){
    object MovieScreen : Screen("movie_screen")
    object MovieDetailScreen : Screen("movie_detail_screen")
    object HomeScreen : Screen("home_screen")
    object SearchScreen : Screen("search_screen")
    object SettingsScreen : Screen("settings_screen")

}

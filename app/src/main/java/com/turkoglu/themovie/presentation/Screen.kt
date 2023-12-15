package com.turkoglu.themovie.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route:String, val title: String, val icon: ImageVector){
    object Home: Screen("home_screen", "Home", Icons.Default.Home)
    object DetailScreen: Screen("movie_details_screen","Detail",Icons.Default.Face)
    object YoutubePlayerScreen: Screen("youtube_player_screen","Youtube",Icons.Default.PlayArrow)
    object SearchPageScreen: Screen("search_page_screen", "Search", Icons.Default.Search)
    object ProfileScreen : Screen("profile", "Profile", Icons.Default.AccountCircle)
    object FavoriteScreen : Screen("favorite", "Favorite", Icons.Default.Favorite)
}

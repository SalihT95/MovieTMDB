package com.turkoglu.themovie.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destinations {
    val title : String
    val route : String
    val routeWithArgs : String
    val icon : ImageVector
}
val movieDestinations = listOf(Home,Search,Fav,Settings)
object Home : Destinations{
    override val title: String
        get() = "Movies"
    override val route: String
        get() = "home"
    override val routeWithArgs: String
        get() = route
    override val icon: ImageVector
        get() = Icons.Default.Home

}
object Detail : Destinations{
    override val title: String
        get() = "Movie Detail"
    override val route: String
        get() = "detail"
    override val routeWithArgs: String
        get() = "$route/{movieId}"
    override val icon: ImageVector
        get() = Icons.Default.Face

    val arguments = listOf(navArgument("movieId"){
        type = NavType.IntType
    })
}

object Search : Destinations{
    override val title: String
        get() = "Search"
    override val route: String
        get() = "search"
    override val routeWithArgs: String
        get() = route
    override val icon: ImageVector
        get() =Icons.Default.Search

}
object Fav : Destinations{
    override val title: String
        get() = "Favorite"
    override val route: String
        get() = "fav"
    override val routeWithArgs: String
        get() = route
    override val icon: ImageVector
        get() = Icons.Default.Favorite

}
object Settings : Destinations{
    override val title: String
        get() = "Settings"
    override val route: String
        get() = "settings"
    override val routeWithArgs: String
        get() = route
    override val icon: ImageVector
        get() = Icons.Default.Settings

}
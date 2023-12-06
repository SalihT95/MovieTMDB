package com.turkoglu.themovie.common

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destinations {
    val title : String
    val route : String
    val routeWithArgs : String
}
object Home : Destinations{
    override val title: String
        get() = "Movies"
    override val route: String
        get() = "home"
    override val routeWithArgs: String
        get() = route

}
object Detail : Destinations{
    override val title: String
        get() = "Movie Detail"
    override val route: String
        get() = "detail"
    override val routeWithArgs: String
        get() = "$route/{movieId}"

    val arguments = listOf(navArgument("movieId"){
        type = NavType.IntType
    })
}

val movieDestinations = listOf(Home,Detail)
object Search : Destinations{
    override val title: String
        get() = "Search"
    override val route: String
        get() = "search"
    override val routeWithArgs: String
        get() = route

}
object Fav : Destinations{
    override val title: String
        get() = "fav"
    override val route: String
        get() = "fav"
    override val routeWithArgs: String
        get() = route

}
object Settings : Destinations{
    override val title: String
        get() = "settings"
    override val route: String
        get() = "settings"
    override val routeWithArgs: String
        get() = route

}
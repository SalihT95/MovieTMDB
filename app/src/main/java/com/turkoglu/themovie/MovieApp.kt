package com.turkoglu.themovie

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.turkoglu.themovie.common.Detail
import com.turkoglu.themovie.common.Fav
import com.turkoglu.themovie.common.Home
import com.turkoglu.themovie.common.MovieAppBar
import com.turkoglu.themovie.common.Search
import com.turkoglu.themovie.common.Settings
import com.turkoglu.themovie.common.movieDestinations
import com.turkoglu.themovie.presentation.Screen
import com.turkoglu.themovie.presentation.detail.DetailScreen
import com.turkoglu.themovie.presentation.detail.DetailViewModel
import com.turkoglu.themovie.presentation.fav.FavViewModel
import com.turkoglu.themovie.presentation.home.HomeScreen
import com.turkoglu.themovie.presentation.home.HomeViewModel
import com.turkoglu.themovie.presentation.search.SearchScreen
import com.turkoglu.themovie.presentation.search.SearchViewModel


@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MovieApp() {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val scaffoldState = rememberScaffoldState()

    val isSystemDark = isSystemInDarkTheme()
    val statusBarColor = if (isSystemDark){
        MaterialTheme.colors.primaryVariant
    }else {
        Color.Transparent
    }
    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor, darkIcons = !isSystemDark)
    }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = movieDestinations.find {
        backStackEntry?.destination?.route == it.route ||
                backStackEntry?.destination?.route == it.routeWithArgs
    }?: Home

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen
            ) {
                navController.navigateUp()
            }
        },
        bottomBar = {
            BottomNavigation {
                movieDestinations.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.title) },
                        selected = currentScreen.route == screen.route,
                        onClick = {
                            if (currentScreen.route != screen.route) {
                                navController.navigate(screen.route) {
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) {innerPaddings ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPaddings),
            startDestination = Home.routeWithArgs
        ){
            composable(Home.routeWithArgs){
                val homeViewModel: HomeViewModel = hiltViewModel()
                HomeScreen(
                    uiState = homeViewModel.uiState,
                    loadNextMovies = {
                        homeViewModel.loadMovies(forceReload = it)
                    },
                    navigateToDetail = {
                        navController.navigate(
                            "${Detail.route}/${it.id}"
                        )
                    }
                )
            }
            composable(Search.routeWithArgs){
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen()
            }

            composable(Fav.routeWithArgs){
                val viewModel: FavViewModel = hiltViewModel()
                SearchScreen()
            }
            composable(Settings.routeWithArgs){
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen()
            }
            composable(Detail.routeWithArgs, arguments = Detail.arguments){
                val movieId = it.arguments?.getInt("movieId") ?: 0
                val detailViewModel: DetailViewModel = hiltViewModel()

                DetailScreen(uiState = detailViewModel.uiState)
            }
        }

    }
}

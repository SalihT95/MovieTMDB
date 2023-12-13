package com.turkoglu.themovie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.turkoglu.themovie.MovieApp
import com.turkoglu.themovie.common.Destinations
import com.turkoglu.themovie.common.Home
import com.turkoglu.themovie.presentation.ui.TheMovieTheme
import dagger.hilt.android.AndroidEntryPoint

data class BottomNavigationItem(
    val title : String,
    val selectedIcon : ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews : Boolean,
    val badgeCount : Int?  = null
)


@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheMovieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MovieApp()
                }
            }
        }
    }
}

@Composable
fun BottomTabBar(
    modifier: Modifier,
    backgroundColor: Color,
    elevation: Dp,
    function: () -> Unit) {
    var selectedTab by remember { mutableStateOf(Home.route) }

    BottomTabBar(
        Modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 4.dp
    ) {

    }
}


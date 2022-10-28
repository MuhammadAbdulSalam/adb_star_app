package com.adbsalam.star.ui.screens.homescreen.homeactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adbsalam.star.ui.screens.homescreen.navigation.NavigationGraph
import com.adbsalam.star.ui.screens.homescreen.navigation.NavigationGraphRoutes
import com.adbsalam.star.ui.theme.Adb_salam_starTheme_fullscreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainHomeScreenActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent{
            Adb_salam_starTheme_fullscreen() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeActivityScreen()
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeActivityScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigation(navController = navController) }) {
        it.calculateBottomPadding()
        NavigationGraph(navController = navController)
    }
}

@Composable
fun BottomNavigation(navController: NavController){
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(NavigationGraphRoutes.Home, NavigationGraphRoutes.Search, NavigationGraphRoutes.Saved, NavigationGraphRoutes.Account,)

    NavigationBar {
        items.forEachIndexed { index, item ->
            val image: Painter = painterResource(id = item.icon)
            NavigationBarItem(
                icon =  {Icon(image, contentDescription = "",)},
                label = { Text(item.title) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    when(selectedItem){
                        0 -> navController.navigate(NavigationGraphRoutes.Home.screen_route){
                            popUpTo(NavigationGraphRoutes.Home.screen_route){
                                inclusive = true
                            }
                        }
                        1 -> navController.navigate(NavigationGraphRoutes.Search.screen_route)
                        2 -> navController.navigate(NavigationGraphRoutes.Saved.screen_route)
                        3 -> navController.navigate(NavigationGraphRoutes.Account.screen_route)
                    }
                }
            )
        }
    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Adb_salam_starTheme_fullscreen {
        HomeActivityScreen()
    }
}
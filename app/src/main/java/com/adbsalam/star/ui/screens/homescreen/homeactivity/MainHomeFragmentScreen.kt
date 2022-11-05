package com.adbsalam.star.ui.screens.homescreen.homeactivity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.adbsalam.star.R
import com.adbsalam.star.ui.screens.homescreen.rootnav.BottomNavItem
import com.adbsalam.star.ui.screens.homescreen.rootnav.NavigationGraph
import com.adbsalam.star.ui.theme.Adb_salam_starTheme_fullscreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Adb_salam_starTheme_fullscreen(isBottomBarTheme = true) {
           Scaffold(
               bottomBar = { HomeBottomNavBar(navController = navController) }
           ) {
               Box(modifier = Modifier.padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding())) {
                   NavigationGraph(navController = navController)
               }
           }
        }
}

@Composable
fun HomeBottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Saved,
        BottomNavItem.Account,
    )
    NavigationBar(
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                alwaysShowLabel = false,
                label = { Text(text = item.title, fontSize = 12.sp) },
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route -> popUpTo(screen_route) {
                            saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
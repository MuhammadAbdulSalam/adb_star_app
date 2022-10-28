package com.adbsalam.star.ui.screens.homescreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adbsalam.star.ui.screens.homescreen.homefrags.account.AccountScreen
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.MainHomeScreen
import com.adbsalam.star.ui.screens.homescreen.homefrags.saved.SavedScreen
import com.adbsalam.star.ui.screens.homescreen.homefrags.search.SearchScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationGraphRoutes.Home.screen_route) {
        composable(NavigationGraphRoutes.Home.screen_route) {
            MainHomeScreen()
        }
        composable(NavigationGraphRoutes.Search.screen_route) {
            SearchScreen()
        }
        composable(NavigationGraphRoutes.Saved.screen_route) {
            SavedScreen()
        }
        composable(NavigationGraphRoutes.Account.screen_route) {
            AccountScreen()
        }
    }
}
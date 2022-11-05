package com.adbsalam.star.ui.screens.homescreen.rootnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adbsalam.star.R
import com.adbsalam.star.ui.screens.homescreen.homefrags.account.AccountScreen
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.MainHomeScreen
import com.adbsalam.star.ui.screens.homescreen.homefrags.saved.SavedScreen
import com.adbsalam.star.ui.screens.homescreen.homefrags.search.SearchScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            MainHomeScreen()
        }
        composable(BottomNavItem.Search.screen_route) {
            SearchScreen()
        }
        composable(BottomNavItem.Saved.screen_route) {
            SavedScreen()
        }
        composable(BottomNavItem.Account.screen_route) {
            AccountScreen()
        }
    }
}

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Home : BottomNavItem("Home", R.drawable.ic_outline_home_24,"home")
    object Search: BottomNavItem("Search",R.drawable.ic_outline_manage_search_24,"search")
    object Saved: BottomNavItem("Saved",R.drawable.ic_baseline_data_saver_on_24,"saved")
    object Account: BottomNavItem("Account",R.drawable.ic_outline_person_24,"account")
}
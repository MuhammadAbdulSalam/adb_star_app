package com.adbsalam.star.ui.screens.homescreen.navigation

import com.adbsalam.star.R

sealed class NavigationGraphRoutes(var title:String, var icon:Int, var screen_route:String){

    object Home : NavigationGraphRoutes("Home", R.drawable.ic_outline_home_24,"home")
    object Search: NavigationGraphRoutes("Search",R.drawable.ic_outline_manage_search_24,"my_network")
    object Saved: NavigationGraphRoutes("Saved",R.drawable.ic_baseline_data_saver_on_24,"add_post")
    object Account: NavigationGraphRoutes("Account",R.drawable.ic_outline_person_24,"notification")
}
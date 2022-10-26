package com.adbsalam.star.navigation.mainactivitynavigation

object MainActivityNavigationRouter {

    fun fromRoute(route: String): MainActivityNavigationRoutes{
        val currentRoute = MainActivityNavigationRoutes.values().firstOrNull{
            route == it.name
        }
        return currentRoute?: MainActivityNavigationRoutes.ERROR_SCREEN
    }
}
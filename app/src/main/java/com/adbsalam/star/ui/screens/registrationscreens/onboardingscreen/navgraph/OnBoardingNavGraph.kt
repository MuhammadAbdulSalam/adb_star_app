package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen.OnBoardingScreen

@Composable
fun OnBoardingNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = OnBoardingScreenRoutes.OnBoarding.route
    ) {
        composable(route = OnBoardingScreenRoutes.OnBoarding.route) {
            OnBoardingScreen()
        }
    }
}
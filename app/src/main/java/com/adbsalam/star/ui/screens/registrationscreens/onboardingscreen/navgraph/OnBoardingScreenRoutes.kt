package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen.navgraph


sealed class OnBoardingScreenRoutes(val route: String) {
    object OnBoarding : OnBoardingScreenRoutes(route = "onBoarding_screen")
    object onBoardingCompleted : OnBoardingScreenRoutes(route = "onBoarding_completed_screen")
}
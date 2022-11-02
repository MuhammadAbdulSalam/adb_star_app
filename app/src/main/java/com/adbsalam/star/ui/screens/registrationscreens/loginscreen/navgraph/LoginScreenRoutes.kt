package com.adbsalam.star.ui.screens.registrationscreens.loginscreen.navgraph

sealed class LoginScreenRoutes(val route: String) {
    object OnLogin : LoginScreenRoutes(route = "login_screen")
    object OnRegistration : LoginScreenRoutes(route = "registration_screen")
}
package com.adbsalam.star.ui.screens.registrationscreens.loginscreen.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adbsalam.star.ui.screens.registrationscreens.loginscreen.LoginScreenCompose
import com.adbsalam.star.ui.screens.registrationscreens.loginscreen.registrationscreen.RegistrationScreen

@Composable
fun LoginNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LoginScreenRoutes.OnLogin.route
    ) {
        composable(route = LoginScreenRoutes.OnLogin.route) {
            LoginScreenCompose(navController)
        }
        composable(route = LoginScreenRoutes.OnRegistration.route) {
            RegistrationScreen()
        }
    }
}
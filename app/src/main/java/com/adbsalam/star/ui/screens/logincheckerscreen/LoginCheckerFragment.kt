package com.adbsalam.star.ui.screens.logincheckerscreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.adbsalam.star.StartingPointCompose
import com.adbsalam.star.navigation.mainactivitynavigation.MainActivityNavigationRoutes
import com.adbsalam.star.ui.theme.Adb_salam_starTheme
import com.adbsalam.star.ui.uiutil.FullScreenLoadingView


@Composable
fun LoginCheckerCompose(navController: NavController) {
    FullScreenLoadingView()
    navController.navigate(MainActivityNavigationRoutes.LOGIN_SCREEN.name){
        popUpTo(MainActivityNavigationRoutes.LOGIN_CHECKER.name){
            inclusive = true
        }
    }
}

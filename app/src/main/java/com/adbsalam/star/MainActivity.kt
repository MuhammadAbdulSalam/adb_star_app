package com.adbsalam.star

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adbsalam.star.navigation.mainactivitynavigation.MainActivityNavigationRoutes.LOGIN_CHECKER
import com.adbsalam.star.navigation.mainactivitynavigation.MainActivityNavigationRoutes.LOGIN_SCREEN
import com.adbsalam.star.ui.screens.logincheckerscreen.LoginCheckerCompose
import com.adbsalam.star.ui.screens.loginscreen.LoginScreenCompose
import com.adbsalam.star.ui.theme.Adb_salam_starTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Adb_salam_starTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StartingPointCompose()
                }
            }
        }

    }
}

@Composable
fun StartingPointCompose() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LOGIN_CHECKER.name) {
        composable(LOGIN_CHECKER.name) { LoginCheckerCompose(navController) }
        composable(LOGIN_SCREEN.name) { LoginScreenCompose(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Adb_salam_starTheme {
        StartingPointCompose()
    }
}
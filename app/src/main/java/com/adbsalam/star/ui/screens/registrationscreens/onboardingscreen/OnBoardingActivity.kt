package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.FragmentActivity
import com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen.navgraph.OnBoardingNavGraph
import com.adbsalam.star.ui.theme.Adb_salam_starTheme_fullscreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity: FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnBoardingStart()
        }
    }
}

@Composable
private fun OnBoardingStart() {
    Adb_salam_starTheme_fullscreen {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            OnBoardingNavGraph()
        }
    }
}
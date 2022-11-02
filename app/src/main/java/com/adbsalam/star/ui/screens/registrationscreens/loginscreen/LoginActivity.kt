package com.adbsalam.star.ui.screens.registrationscreens.loginscreen

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.adbsalam.star.ui.screens.registrationscreens.loginscreen.navgraph.LoginNavGraph
import com.adbsalam.star.ui.theme.Adb_salam_starTheme_fullscreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity: FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Adb_salam_starTheme_fullscreen {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = lightColorScheme().surface
                    ){
                        LoginNavGraph()
                    }
            }
        }
    }
}
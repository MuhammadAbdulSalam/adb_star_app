package com.adbsalam.star.ui.screens.registrationscreens.logincheckerscreen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.adbsalam.star.ui.screens.registrationscreens.loginscreen.LoginActivity
import com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen.OnBoardingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : FragmentActivity() {

    private val viewModel by viewModels<LoginCheckerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }
        lifecycleScope.launchWhenCreated {
            viewModel.onBoardingState.collectLatest {
                delay(3000)
                if (it) navigateToOnBoarding() else navigateToLoginFragment()
            }
        }
    }


    fun navigateToLoginFragment(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun navigateToOnBoarding(){
        val intent = Intent(this@MainActivity, OnBoardingActivity::class.java)
        startActivity(intent)
        finish()
    }

}


package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen


import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.ui.screens.registrationscreens.loginscreen.LoginActivity
import com.adbsalam.star.ui.theme.Adb_salam_starTheme_fullscreen
import com.adbsalam.star.ui.uiutil.AppAnimatedButton
import com.adbsalam.star.ui.uiutil.pager.AppPager
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.PagerModel
import com.adbsalam.star.utility.launchActivity
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(viewModel: OnBoardingViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(3)
    val pages = listOf(OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third)
    val enable = pagerState.currentPage != 0

    BackHandler(enabled = enable) {
        scope.launch {
            pagerState.scrollToPage(pagerState.currentPage - 1)
        }
    }

    val btnFinish = ButtonModel(buttonText = "Finish", onClickListener = {
            viewModel.saveOnBoardingState(completed = true)
            context.launchActivity<LoginActivity> {
                val activity = context as OnBoardingActivity
                activity.finish()
            }
        }
    )

    val pagerModel = PagerModel(
        pagerList = pages,
        pagerState = pagerState,
        tailingComposable = { modifier -> AppAnimatedButton(modifier, buttonModel = btnFinish, visibility = pagerState.currentPage == 2) }
    )

    AppPager(pagerModel = pagerModel)
}


@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    Adb_salam_starTheme_fullscreen() {
        OnBoardingScreen()
    }
}


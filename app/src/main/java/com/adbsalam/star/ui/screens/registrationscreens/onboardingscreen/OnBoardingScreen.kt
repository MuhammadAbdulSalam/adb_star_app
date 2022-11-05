package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen


import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.R
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
    val enable = pagerState.currentPage != 0

    BackHandler(enabled = enable) {
        scope.launch {
            pagerState.animateScrollToPage(pagerState.currentPage - 1)
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

    val pagesList = listOf(
        PagerModel.PageModel(composableScreen = {OnBoardingPageScreen(R.drawable.ic_outline_home_24, "Home", "See list of popular, latest and upcoming movies")}),
        PagerModel.PageModel(composableScreen = {OnBoardingPageScreen(R.drawable.ic_outline_manage_search_24, "Search","Search for your favourite movies and TV Series on demand") }),
        PagerModel.PageModel(composableScreen = {OnBoardingPageScreen(R.drawable.ic_baseline_data_saver_on_24,"Store", "Store your collection of movies and TV Series in one place.")})
    )

    val pagerModel = PagerModel(
        pagerList = pagesList,
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






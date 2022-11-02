package com.adbsalam.star.ui.uiutil.uidatamodels

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen.OnBoardingPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
data class PagerModel(
    val pagerList: List<OnBoardingPage>,
    val pagerState: PagerState,
    val tailingComposable: @Composable (modifier: Modifier) -> Unit = {}
)

package com.adbsalam.star.ui.screens.homescreen.homefrags.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.R.*
import com.adbsalam.star.ui.screens.homescreen.viewmodel.HomeScreenViewModel
import com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen.OnBoardingPage
import com.adbsalam.star.ui.uiutil.GetAppBarLogoImage
import com.adbsalam.star.ui.uiutil.TabLayout
import com.adbsalam.star.ui.uiutil.pager.AppPager
import com.adbsalam.star.ui.uiutil.uidatamodels.PagerModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainHomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    val pagerState = rememberPagerState(2)
    val pages = listOf(OnBoardingPage.First, OnBoardingPage.Second)
    val pagerModel = PagerModel(
        pagerList = pages,
        pagerState = pagerState,
        requireIndicator = false
        )

    Column() {
        TopAppBar(backgroundColor = lightColorScheme().surface) { GetAppBarLogoImage() }
        TabLayout(pagerState = pagerModel.pagerState, listOf("Popular", "Latest"))
        AppPager(pagerModel = pagerModel)
    }

}

package com.adbsalam.star.ui.screens.homescreen.homefrags.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.R.*
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.latest.LatestScreenUiManipulator
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.popular.PopularScreenUiManipulator
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.latest.LatestMoviesViewModel
import com.adbsalam.star.ui.uiutil.GetAppBarLogoImage
import com.adbsalam.star.ui.uiutil.TabLayout
import com.adbsalam.star.ui.uiutil.pager.AppPager
import com.adbsalam.star.ui.uiutil.uidatamodels.PagerModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainHomeScreen(viewModel: LatestMoviesViewModel = hiltViewModel()) {
    val pagerState = rememberPagerState(2)
    val uiState by viewModel.uiState.collectAsState()

    val pagesList = listOf(
        PagerModel.PageModel("Latest") { LatestScreenUiManipulator(uiState = uiState) } ,
        PagerModel.PageModel("Popular") { PopularScreenUiManipulator(uiState = uiState) }
    )

    val pagerModel = PagerModel(pagerList = pagesList, pagerState = pagerState, requireIndicator = false)

    Column() {
        TopAppBar(backgroundColor = lightColorScheme().surface) { GetAppBarLogoImage() }
        TabLayout(pagerModel)
        AppPager(pagerModel = pagerModel)
    }

}
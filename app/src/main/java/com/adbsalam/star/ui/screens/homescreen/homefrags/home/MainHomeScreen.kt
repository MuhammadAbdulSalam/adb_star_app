package com.adbsalam.star.ui.screens.homescreen.homefrags.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.R.*
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.latest.LatestScreenUiManipulator
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.popular.PopularScreenUiManipulator
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.latest.LatestMoviesViewModel
import com.adbsalam.star.ui.theme.Transparent_Alpha4
import com.adbsalam.star.ui.uiutil.GetAppBarLogoImage
import com.adbsalam.star.ui.uiutil.TabLayout
import com.adbsalam.star.ui.uiutil.pager.AppPager
import com.adbsalam.star.ui.uiutil.uidatamodels.PagerModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainHomeScreen() {
    val pagerState = rememberPagerState()

    val pagesList = listOf(
        PagerModel.PageModel("Latest") { LatestScreenUiManipulator() } ,
        PagerModel.PageModel("Popular") { PopularScreenUiManipulator( pagerState = pagerState) }
    )

    val pagerModel = PagerModel(pagerList = pagesList, pagerState = pagerState, requireIndicator = false, dragEnabled = false)

    Box() {
        AppPager(pagerModel = pagerModel, isDark = true)

        Column(modifier = Modifier.fillMaxWidth().align(Alignment.TopStart)){
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Transparent_Alpha4)
            )
            TabLayout(pagerModel)
        }
    }

}
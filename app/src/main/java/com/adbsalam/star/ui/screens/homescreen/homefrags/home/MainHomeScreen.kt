package com.adbsalam.star.ui.screens.homescreen.homefrags.home

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.adbsalam.star.R.*
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.latest.LatestScreenUiManipulator
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.popular.PopularScreenUiManipulator
import com.adbsalam.star.ui.uiutil.ScrollState
import com.adbsalam.star.ui.uiutil.getNestedScrollConnection
import com.adbsalam.star.ui.uiutil.pager.AppPager
import com.adbsalam.star.ui.uiutil.recycleritems.FloatingBottomBar
import com.adbsalam.star.ui.uiutil.recycleritems.MoviesTopTabbedBar
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
    val scrollDirection = remember { mutableStateOf(ScrollState.NO_SCROLL) }

    Box(modifier = Modifier.nestedScroll(getNestedScrollConnection(scrollDirection))) {
        AppPager(pagerModel = pagerModel, isDark = true)
        MoviesTopTabbedBar(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopStart), pagerModel = pagerModel, scrollDirection)
        FloatingBottomBar(modifier = Modifier.align(Alignment.BottomCenter), scrollState = scrollDirection)
    }
}



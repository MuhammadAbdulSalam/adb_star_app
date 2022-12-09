package com.adbsalam.star.ui.screens.homescreen.homefrags.home

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.buildAnnotatedString
import com.adbsalam.star.R.*
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.latest.LatestScreenUiManipulator
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.popular.PopularScreenUiManipulator
import com.adbsalam.star.ui.uiutil.FloatingBottomBar
import com.adbsalam.star.ui.uiutil.ScrollState
import com.adbsalam.star.ui.uiutil.getNestedScrollConnection
import com.adbsalam.star.ui.uiutil.pager.AppPager
import com.adbsalam.star.ui.uiutil.recycleritems.MoviesTopTabbedBar
import com.adbsalam.star.ui.uiutil.uidatamodels.AppClickableIcons
import com.adbsalam.star.ui.uiutil.uidatamodels.PagerModel
import com.adbsalam.star.utility.MainUiForComposable
import com.adbsalam.star.utility.UIComponent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainHomeScreenManipulator(){
    val pagerState = rememberPagerState()
    val scrollDirection = remember { mutableStateOf(ScrollState.NO_SCROLL) }

    val appBottomBarBtnRefresh = AppClickableIcons(Icons.Default.Refresh)
    val appBottomBarBtnTop = AppClickableIcons(Icons.Default.KeyboardArrowUp)
    val appBottomBarBtnEnd = AppClickableIcons(Icons.Default.KeyboardArrowDown)

    val pagesList = listOf(
        PagerModel.PageModel("Latest") { LatestScreenUiManipulator() } ,
        PagerModel.PageModel("Popular") { PopularScreenUiManipulator(pagerState = pagerState) }
    )

    val pagerModel = PagerModel(pagerList = pagesList, pagerState = pagerState, requireIndicator = false, dragEnabled = false)

    @MainUiForComposable UIComponent {
        MainHomeScreenUi(
            scrollDirection = scrollDirection,
            pagerModel = pagerModel,
            list = listOf(appBottomBarBtnRefresh, appBottomBarBtnTop, appBottomBarBtnEnd))
    }
}

@MainUiForComposable()
@Composable
fun MainHomeScreenUi(scrollDirection: MutableState<ScrollState>, pagerModel: PagerModel, list: List<AppClickableIcons>){
    Box(modifier = Modifier.nestedScroll(getNestedScrollConnection(scrollDirection))) {
        AppPager(pagerModel = pagerModel, isDark = true)
        MoviesTopTabbedBar(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopStart), pagerModel = pagerModel, scrollDirection)
        FloatingBottomBar(modifier = Modifier.align(Alignment.BottomCenter), scrollState = scrollDirection, list)
    }
}




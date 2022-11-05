package com.adbsalam.star.ui.screens.homescreen.homefrags.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adbsalam.star.R.*
import com.adbsalam.star.ui.uiutil.GetAppBarLogoImage
import com.adbsalam.star.ui.uiutil.TabLayout
import com.adbsalam.star.ui.uiutil.pager.AppPager
import com.adbsalam.star.ui.uiutil.uidatamodels.PagerModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainHomeScreen() {
    val pagerState = rememberPagerState(2)

    val pagesList = listOf(
        PagerModel.PageModel("Latest") { LatestScreen() } ,
        PagerModel.PageModel("Popular") { PopularScreen() }
    )

    val pagerModel = PagerModel(pagerList = pagesList, pagerState = pagerState, requireIndicator = false)

    Column() {
        TopAppBar(backgroundColor = lightColorScheme().surface) { GetAppBarLogoImage() }
        TabLayout(pagerModel)
        AppPager(pagerModel = pagerModel)
    }

}


@Composable
fun LatestScreen(){
    Column(Modifier.fillMaxSize()) {
        Text(text = "Page Latest")
    }
}

@Composable
fun PopularScreen(){
    Column(Modifier.fillMaxSize()) {
        Text(text = "Page Popular")
    }}

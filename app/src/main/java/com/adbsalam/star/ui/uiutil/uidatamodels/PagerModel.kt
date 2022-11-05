package com.adbsalam.star.ui.uiutil.uidatamodels

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
data class PagerModel(
    val pagerList: List<PageModel>,
    val pagerState: PagerState,
    val requireIndicator: Boolean = true,
    val dragEnabled: Boolean = true,
    val tailingComposable: @Composable (modifier: Modifier) -> Unit = {}
){
    data class PageModel(
        val title: String = "",
        val composableScreen: @Composable() ()-> Unit
    )
}

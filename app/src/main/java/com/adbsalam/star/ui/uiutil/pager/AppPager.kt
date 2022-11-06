package com.adbsalam.star.ui.uiutil.pager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.adbsalam.star.ui.uiutil.uidatamodels.PagerModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator


@Composable
@OptIn(ExperimentalPagerApi::class)
fun AppPager(pagerModel: PagerModel, isDark: Boolean = false){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if(isDark) Color.Black else lightColorScheme().surface)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerModel.pagerState,
            verticalAlignment = Alignment.Top,
            count = pagerModel.pagerList.size,
            userScrollEnabled = pagerModel.dragEnabled
            ) { position ->
           pagerModel.pagerList[position].composableScreen()
        }
        if(pagerModel.requireIndicator){
            HorizontalPagerIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(1f),
                pagerState = pagerModel.pagerState,
                activeColor = lightColorScheme().primary
            )
        }
        if(pagerModel.tailingComposable != {}){
            pagerModel.tailingComposable(Modifier.weight(1f))
        }
    }
}


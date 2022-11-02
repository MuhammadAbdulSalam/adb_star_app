package com.adbsalam.star.ui.uiutil.pager

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.lightColors
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen.OnBoardingPage
import com.adbsalam.star.ui.uiutil.FullScreenColumn
import com.adbsalam.star.ui.uiutil.LinearLayoutCompose
import com.adbsalam.star.ui.uiutil.uidatamodels.PagerModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator


@Composable
@OptIn(ExperimentalPagerApi::class)
fun AppPager(pagerModel: PagerModel){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightColors().onPrimary)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerModel.pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pagerModel.pagerList[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerModel.pagerState,
            activeColor = lightColorScheme().primary
        )
        if(pagerModel.tailingComposable != {}){
            pagerModel.tailingComposable(Modifier.weight(1f))
        }

    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    val heading = TextModel(onBoardingPage.title, TextModel.TextType.SUB_HEADING)
    val content = TextModel(onBoardingPage.description)

    FullScreenColumn(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image"
        )
        LinearLayoutCompose(modelView = listOf(heading, content))
    }
}
package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.lightColors
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.ui.theme.Adb_salam_starTheme_fullscreen
import com.google.accompanist.pager.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(viewModel: OnBoardingViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState(3)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightColors().onPrimary)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState,
//            activeColor = colorResource(R.)
        )
        FinishButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState
        ) {
            viewModel.saveOnBoardingState(completed = true)
//            context.launchActivity<MainActivity> { }
        }
    }
}

    @Composable
    fun PagerScreen(onBoardingPage: OnBoardingPage) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(0.7f),
                painter = painterResource(id = onBoardingPage.image),
                contentDescription = "Pager Image"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = onBoardingPage.title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(top = 20.dp),
                text = onBoardingPage.description,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun FinishButton(
        modifier: Modifier,
        pagerState: PagerState,
        onClick: () -> Unit
    ) {
        Row(
            modifier = modifier
                .padding(horizontal = 40.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(
                modifier = Modifier.fillMaxWidth(),
                visible = pagerState.currentPage == 2
            ) {
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red
                    ),
                    shape = RectangleShape
                ) {
                    androidx.compose.material.Text(
                        text = "Finish",
                        color = White,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    Adb_salam_starTheme_fullscreen() {
        OnBoardingScreen()
    }
}


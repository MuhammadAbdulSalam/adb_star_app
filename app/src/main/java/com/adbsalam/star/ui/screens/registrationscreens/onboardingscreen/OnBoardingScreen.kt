package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen


import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.ui.screens.registrationscreens.loginscreen.LoginActivity
import com.adbsalam.star.ui.theme.Adb_salam_starTheme_fullscreen
import com.adbsalam.star.ui.uiutil.AppButton
import com.adbsalam.star.ui.uiutil.pager.AppPager
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.PagerModel
import com.adbsalam.star.utility.launchActivity
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(viewModel: OnBoardingViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val pages = listOf(OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third)
    val pagerState = rememberPagerState(3)
    val enable = pagerState.currentPage != 0

    BackHandler(enabled = enable) {
        scope.launch {
            pagerState.scrollToPage(pagerState.currentPage - 1)
        }
    }

    val pagerModel = PagerModel(
        pagerList = pages,
        pagerState = pagerState,
        tailingComposable = { modifier ->
            FinishButton(modifier = modifier, pagerState = pagerState) {
                viewModel.saveOnBoardingState(completed = true)
                context.launchActivity<LoginActivity> {}
            }
        }
    )

    AppPager(pagerModel = pagerModel)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(modifier: Modifier, pagerState: PagerState, onClick: () -> Unit) {
    Row(
        modifier = modifier.padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            AppButton(ButtonModel("Finish", onClickListener = onClick))
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


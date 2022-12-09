package com.adbsalam.star.ui.screens.homescreen.homefrags.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adbsalam.star.ui.theme.Adb_Salam_StarTheme_Fullscreen_Dark
import com.adbsalam.star.ui.uiutil.AppSearchTextView
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel


private val searchTextField = TextViewModel("Search")


@Composable
fun SearchScreen() {

    Adb_Salam_StarTheme_Fullscreen_Dark(isBottomBarTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(darkColorScheme().surface)
                .statusBarsPadding()
        ){
            AppSearchTextView()
        }
    }
}


@Preview
@Composable
fun showPreview(){
    SearchScreen()
}

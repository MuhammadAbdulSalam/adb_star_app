package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.adbsalam.star.R
import com.adbsalam.star.ui.uiutil.FullScreenColumn
import com.adbsalam.star.ui.uiutil.LinearLayoutCompose
import com.adbsalam.star.ui.uiutil.uidatamodels.TextModel


@Composable
fun OnBoardingPageScreen( @DrawableRes image: Int,title: String, description: String){
    val heading = TextModel(title, TextModel.TextType.SUB_HEADING)
    val content = TextModel(description)

    FullScreenColumn(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = image),
            contentDescription = "Pager Image"
        )
        LinearLayoutCompose(modelView = listOf(heading, content))
    }
}
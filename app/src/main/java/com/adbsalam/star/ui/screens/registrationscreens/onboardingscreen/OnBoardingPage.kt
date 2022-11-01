package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen

import androidx.annotation.DrawableRes
import com.adbsalam.star.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.ic_outline_home_24,
        title = "Characters",
        description = "You can access the list of characters and details."
    )

    object Second : OnBoardingPage(
        image = R.drawable.ic_outline_manage_search_24,
        title = "Episodes",
        description = "You can access the list of episodes and details."
    )

    object Third : OnBoardingPage(
        image = R.drawable.ic_outline_person_24,
        title = "Locations",
        description = "You can access the list of locations and details."
    )
}
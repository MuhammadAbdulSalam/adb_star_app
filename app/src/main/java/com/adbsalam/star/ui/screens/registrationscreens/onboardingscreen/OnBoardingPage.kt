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
        title = "Home",
        description = "See list of popular, latest and upcoming movies"
    )

    object Second : OnBoardingPage(
        image = R.drawable.ic_outline_manage_search_24,
        title = "Search",
        description = "Search for your favourite movies and TV Series on demand"
    )

    object Third : OnBoardingPage(
        image = R.drawable.ic_baseline_data_saver_on_24,
        title = "Store",
        description = "Store your collection of movies and TV Series in one place."
    )
}
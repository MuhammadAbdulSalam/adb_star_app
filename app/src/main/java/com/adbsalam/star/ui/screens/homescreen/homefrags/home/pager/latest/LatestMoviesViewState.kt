package com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.latest

import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import kotlinx.coroutines.flow.MutableSharedFlow

data class LatestMoviesUiState(
    val moviesList: MutableSharedFlow<Result<PopularMoviesResponse>>
    )

sealed class LatestMoviesEvents {
    object LoadMovies : LatestMoviesEvents()
    data class AddOrRemoveFromStored(val movie: PopularMoviesResponse.PopularMoviesList) : LatestMoviesEvents()
}


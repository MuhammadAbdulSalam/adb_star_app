package com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.popular

import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import kotlinx.coroutines.flow.MutableSharedFlow

data class PopularMoviesViewState(val moviesList: MutableSharedFlow<Result<PopularMoviesResponse>>)

sealed class PopularMoviesEvents {
    object LoadMovies : PopularMoviesEvents()
    data class AddOrRemoveFromStored(val movie: PopularMoviesResponse.PopularMoviesList) : PopularMoviesEvents()
}


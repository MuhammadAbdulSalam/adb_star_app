package com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.popular

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import com.adbsalam.star.core.BaseViewState
import com.adbsalam.star.ui.uiutil.FullScreenLoadingView
import com.adbsalam.star.ui.uiutil.recycleritems.LoadMoviesListView
import com.adbsalam.star.utility.MainUiForComposable
import com.adbsalam.star.utility.UIComponent
import com.adbsalam.star.utility.cast
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PopularScreenUiManipulator(viewModel: PopularMoviesViewModel = hiltViewModel(), pagerState: PagerState) {
    val moviesList = remember { mutableStateOf(listOf<PopularMoviesResponse.PopularMoviesList>()) }
    val uiState by viewModel.uiState.collectAsState()

    if(pagerState.currentPage == 1){
        LaunchedEffect(key1 = viewModel, block = {
            if (moviesList.value.isEmpty() ) {
                viewModel.onTriggerEvent(PopularMoviesEvents.LoadMovies)
            }
        })
    }

    when (uiState) {
        is BaseViewState.Data -> {
            val value = uiState.cast<BaseViewState.Data<PopularMoviesViewState>>().value
            value.moviesList.replayCache.last().getOrNull()?.results?.let { moviesList.value = it }
            @MainUiForComposable UIComponent { LoadMoviesListView(moviesList = moviesList.value)}
        }
        is BaseViewState.Loading -> @MainUiForComposable UIComponent { FullScreenLoadingView() }
        is BaseViewState.Error -> {}
        is BaseViewState.Empty -> {}
    }
}



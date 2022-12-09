package com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.latest

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import com.adbsalam.star.core.BaseViewState
import com.adbsalam.star.ui.uiutil.FullScreenLoadingView
import com.adbsalam.star.ui.uiutil.recycleritems.LoadMoviesListView
import com.adbsalam.star.utility.MainUiForComposable
import com.adbsalam.star.utility.UIComponent
import com.adbsalam.star.utility.cast

@Composable
fun LatestScreenUiManipulator(viewModel: LatestMoviesViewModel = hiltViewModel()){

    val moviesList = remember { mutableStateOf(listOf<PopularMoviesResponse.PopularMoviesList>())}
    val uiState by viewModel.uiState.collectAsState()

    when(uiState){
        is BaseViewState.Data -> {
            val value = uiState.cast<BaseViewState.Data<LatestMoviesUiState>>().value
            value.moviesList.replayCache.last().getOrNull()?.results?.let { moviesList.value = it }
            @MainUiForComposable UIComponent { LoadMoviesListView(moviesList = moviesList.value) }
        }
        is BaseViewState.Loading -> @MainUiForComposable UIComponent { FullScreenLoadingView() }
        is BaseViewState.Error -> {}
        is BaseViewState.Empty -> {}
    }


    LaunchedEffect(key1 = viewModel, block = {
        if(moviesList.value.isEmpty()){
            viewModel.onTriggerEvent(LatestMoviesEvents.LoadMovies)
        }
    })
}



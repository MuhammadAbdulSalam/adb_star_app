package com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.popular

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import com.adbsalam.star.core.BaseViewState
import com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.latest.LatestMoviesUiState
import com.adbsalam.star.ui.uiutil.FullScreenLoadingView
import com.adbsalam.star.utility.cast

@Composable
fun PopularScreenUiManipulator(viewModel: PopularMoviesViewModel = hiltViewModel(), uiState: BaseViewState<*>) {

    val moviesList = remember { mutableStateOf(listOf<PopularMoviesResponse.PopularMoviesList>()) }

    when (uiState) {
        is BaseViewState.Data -> {
            val value = uiState.cast<BaseViewState.Data<LatestMoviesUiState>>().value
            value.moviesList.replayCache.last().getOrNull()?.results?.let { moviesList.value = it }
            LoadPopularMoviesList(moviesList = moviesList.value)
        }
        is BaseViewState.Error -> {}
        is BaseViewState.Loading -> FullScreenLoadingView()
        else -> {}
    }

    LaunchedEffect(key1 = viewModel, block = {
        if (moviesList.value.isEmpty()) {
            viewModel.onTriggerEvent(PopularMoviesEvents.LoadMovies)
        }
    })
}

@Composable
fun LoadPopularMoviesList(moviesList: List<PopularMoviesResponse.PopularMoviesList>){
    Column(Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            item {
                moviesList.forEach {
                    Text(text = it.title)
                }
            }
        }
    }
}

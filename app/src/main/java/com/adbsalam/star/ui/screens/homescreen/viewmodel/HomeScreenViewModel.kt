package com.adbsalam.star.ui.screens.homescreen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adbsalam.star.api.apirepository.ApiRepository
import com.adbsalam.star.api.data.popular.PopularMovieRequest
import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    private val _popularMovies = MutableSharedFlow<Result<PopularMoviesResponse>>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val popularMovies = _popularMovies.asSharedFlow()

    init {
        loadPopularMovies()
    }


    fun loadPopularMovies() {
        viewModelScope.launch {
            try {
                val popularMoviesResponse = apiRepository.getPopularMovies(PopularMovieRequest())
                _popularMovies.emit(Result.success(popularMoviesResponse))
            } catch (e: java.lang.Exception) {
                _popularMovies.emit(Result.failure(e))
            }
        }
    }

}
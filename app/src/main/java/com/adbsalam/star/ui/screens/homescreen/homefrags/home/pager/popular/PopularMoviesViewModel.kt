package com.adbsalam.star.ui.screens.homescreen.homefrags.home.pager.popular

import androidx.lifecycle.viewModelScope
import com.adbsalam.star.api.apirepository.ApiRepository
import com.adbsalam.star.api.data.popular.PopularMovieRequest
import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import com.adbsalam.star.core.BaseLifecycleViewModel
import com.adbsalam.star.core.BaseViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor (private val apiRepository: ApiRepository) : BaseLifecycleViewModel<BaseViewState<PopularMoviesViewState>, PopularMoviesEvents>() {

    private val _popularMovies = MutableSharedFlow<Result<PopularMoviesResponse>>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    fun loadPopularMovies() {
        setState(BaseViewState.Loading)
        viewModelScope.launch {
            try {
                val popularMoviesResponse = apiRepository.getPopularMovies(PopularMovieRequest())
                _popularMovies.emit(Result.success(popularMoviesResponse))
                setState(BaseViewState.Data(PopularMoviesViewState(moviesList = _popularMovies)))
            } catch (e: java.lang.Exception) {
                _popularMovies.emit(Result.failure(e))
                setState(BaseViewState.Error(e))
            }
        }
    }

    override fun onTriggerEvent(eventType: PopularMoviesEvents) {
        when(eventType){
            is PopularMoviesEvents.LoadMovies -> loadPopularMovies()
            is PopularMoviesEvents.AddOrRemoveFromStored -> {}
            else -> {}
        }
    }
}


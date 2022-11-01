package com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.adbsalam.star.core.BaseViewModel
import com.adbsalam.star.core.usecase.registerusecase.OnBoardingReadUseCase
import com.adbsalam.star.core.usecase.registerusecase.OnBoardingSaveUseCase
import com.adbsalam.star.ui.screens.registrationscreens.onboardingscreen.navgraph.OnBoardingScreenRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val saveOnBoarding: OnBoardingSaveUseCase,
    private val readOnBoarding: OnBoardingReadUseCase
) : BaseViewModel() {

    private val _startDestination: MutableState<String> =
        mutableStateOf(OnBoardingScreenRoutes.OnBoarding.route)
    val startDestination: State<String> = _startDestination

    fun saveOnBoardingState(completed: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        val params = OnBoardingSaveUseCase.Params(completed)
        call(saveOnBoarding(params))
    }

    fun readOnBoardingState() = viewModelScope.launch {
        readOnBoarding(Unit).collect { completed ->
            if (completed) {
                _startDestination.value = OnBoardingScreenRoutes.onBoardingCompleted.route
            } else {
                _startDestination.value = OnBoardingScreenRoutes.OnBoarding.route
            }
        }
    }
}
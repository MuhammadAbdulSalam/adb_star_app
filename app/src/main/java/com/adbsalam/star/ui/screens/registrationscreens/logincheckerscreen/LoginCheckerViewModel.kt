package com.adbsalam.star.ui.screens.registrationscreens.logincheckerscreen

import com.adbsalam.star.core.BaseViewModel
import com.adbsalam.star.core.usecase.registerusecase.OnBoardingReadUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginCheckerViewModel @Inject constructor(private val onRegistration: OnBoardingReadUseCase) : BaseViewModel() {

    private val _onBoardingState = MutableStateFlow(false)
    val onBoardingState = _onBoardingState.asStateFlow()

    init {
        readRegistrationState()
    }

    private fun readRegistrationState() = safeLaunch {
        call(onRegistration(Unit)) { completed ->
            _onBoardingState.value = !completed
        }
    }
}
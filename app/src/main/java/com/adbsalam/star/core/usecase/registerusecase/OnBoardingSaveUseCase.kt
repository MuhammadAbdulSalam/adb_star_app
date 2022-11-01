package com.adbsalam.star.core.usecase.registerusecase

import androidx.annotation.VisibleForTesting
import com.adbsalam.star.api.apirepository.OnBoardingRepository
import com.adbsalam.star.core.usecase.LocalUseCase
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject


class OnBoardingSaveUseCase @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: OnBoardingRepository
) : LocalUseCase<OnBoardingSaveUseCase.Params, Unit>() {

    data class Params(
        val completed: Boolean
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        repository.saveOnBoardingState(params.completed)
        emit(Unit)
    }
}
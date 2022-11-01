package com.adbsalam.star.core.usecase.registerusecase

import androidx.annotation.VisibleForTesting
import com.adbsalam.star.api.apirepository.OnBoardingRepository
import com.adbsalam.star.core.usecase.ReturnUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class OnBoardingReadUseCase @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: OnBoardingRepository
) : ReturnUseCase<Unit, Boolean>() {

    override suspend fun execute(params: Unit): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}
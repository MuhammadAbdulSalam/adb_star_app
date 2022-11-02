package com.adbsalam.star.api.apiinterface

import com.adbsalam.star.api.RetrofitBuilder
import com.adbsalam.star.api.data.popular.PopularMovieRequest
import com.adbsalam.star.utility.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiInterface @Inject constructor(private val apiService: RetrofitBuilder, private val dispatcherProvider: CoroutineDispatcherProvider)  {

    suspend fun getPopularMovies(request: PopularMovieRequest) = withContext(dispatcherProvider.io){
        apiService.getPopularMovies(
            language = request.language,
            page = request.page
        )
    }

}
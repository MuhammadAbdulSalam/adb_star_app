package com.adbsalam.star.api.apirepository

import com.adbsalam.star.api.apiinterface.ApiInterface
import com.adbsalam.star.api.data.popular.PopularMovieRequest
import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiInterface) {

    suspend fun getPopularMovies(request: PopularMovieRequest): PopularMoviesResponse{
       return apiService.getPopularMovies(request)
    }

}
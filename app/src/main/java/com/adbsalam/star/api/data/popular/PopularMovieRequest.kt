package com.adbsalam.star.api.data.popular

import retrofit2.http.Query

data class PopularMovieRequest (
    val language: String = "en-US",
    var page: Int = 1
)
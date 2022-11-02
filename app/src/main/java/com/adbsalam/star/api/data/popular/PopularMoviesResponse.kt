package com.adbsalam.star.api.data.popular

data class PopularMoviesResponse(
    val page: Int,
    val results: List<PopularMoviesList>,
    val total_pages: Int,
    val total_results: Int
) : java.io.Serializable {
    data class PopularMoviesList(
        val adult: Boolean,
        val backdrop_path: String,
        val genre_ids: List<Int>,
        val id: Int,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int
    ) : java.io.Serializable
}
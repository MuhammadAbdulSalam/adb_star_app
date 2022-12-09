package com.adbsalam.star.api

import com.adbsalam.star.BuildConfig
import com.adbsalam.star.api.data.popular.PopularMoviesResponse
import com.adbsalam.star.utility.API_KEY
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface    RetrofitBuilder {


    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String,
        @Query("page") page: Int
    ): PopularMoviesResponse


    /**
     * Retrofit builder component
     */
    companion object {
        private var gson = GsonBuilder()
            .setLenient()
            .create()

        private val logger =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        private val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .callTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .build()

        fun create(): RetrofitBuilder {
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RetrofitBuilder::class.java)
        }
    }
}
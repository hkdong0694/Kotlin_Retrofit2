package com.example.retrofit2.repository

import com.example.retrofit2.network.Constants
import com.example.retrofit2.network.MovieInfoOpenApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit2
 * Class: MovieListRepository
 * Created by 한경동 (Joel) on 2021/05/26.
 * Description:
 */
class MovieListRepository {

    private var retrofit: Retrofit? = null
    private var movieInfoOpenApiService: MovieInfoOpenApiService? = null

    fun initBuild() : MovieInfoOpenApiService? {
        retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        movieInfoOpenApiService = retrofit?.create(MovieInfoOpenApiService::class.java)
        return movieInfoOpenApiService
    }

}
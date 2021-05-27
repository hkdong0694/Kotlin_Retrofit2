package com.example.retrofit2.network

import com.example.retrofit2.network.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit2
 * Class: MovieInfoOpenApiService
 * Created by 한경동 (Joel) on 2021/05/26.
 * Description:
 */
interface MovieInfoOpenApiService {

    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    fun getBoxOffice(
        @Query("key")key: String,
        @Query("targetDt")target: String?
    ): Call<Result>

}
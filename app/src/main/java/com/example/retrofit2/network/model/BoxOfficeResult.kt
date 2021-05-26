package com.example.retrofit2.network.model

/**
 * Retrofit2
 * Class: BoxOfficeResult
 * Created by 한경동 (Joel) on 2021/05/26.
 * Description:
 */
data class BoxOfficeResult(
    var boxofficeType: String,
    var showRange: String,
    var dailyBoxOfficeList: MutableList<DailyBoxOfficeList>
)
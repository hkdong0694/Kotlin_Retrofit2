package com.example.retrofit2.network.model

/**
 * Retrofit2
 * Class: DailyBoxOfficeList
 * Created by 한경동 (Joel) on 2021/05/26.
 * Description:
 */
data class DailyBoxOfficeList(
    var rnum: String,
    var rank: String,
    var rankInten: String,
    var rankOldAndNew: String,
    var movieCd: String,
    var movieNm: String,
    var openDt: String,
    var salesAmt: String,
    var salesInten: String,
    var salesChange: String,
    var salesAcc: String,
    var audiCnt: String,
    var audiInten: String,
    var audiChange: String,
    var audiAcc: String,
    var scrnCnt: String,
    var showCnt: String
)
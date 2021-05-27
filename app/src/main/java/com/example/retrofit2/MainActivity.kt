package com.example.retrofit2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2.adapter.DailyOfficeAdapter
import com.example.retrofit2.network.Constants
import com.example.retrofit2.network.MovieInfoOpenApiService
import com.example.retrofit2.network.model.DailyBoxOfficeList
import com.example.retrofit2.network.model.Result
import com.example.retrofit2.repository.MovieListRepository
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    var adapter: DailyOfficeAdapter? = null
    var repository: MovieListRepository?= null
    var apiInterface: MovieInfoOpenApiService?= null
    var dateSet: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dateInit()
        adapter = DailyOfficeAdapter()
        repository = MovieListRepository()
        apiInterface = repository?.initBuild()

        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = adapter

        boxOfficeSearch()
    }

    private fun dateInit() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val mNow = System.currentTimeMillis()
        val mDate = Date(mNow)
        dateFormat.format(mDate)
        dateSet = dateFormat(dateFormat.calendar.get(Calendar.YEAR), dateFormat.calendar.get(Calendar.MONTH) + 1 , dateFormat.calendar.get(Calendar.DAY_OF_MONTH) -1)
    }

    private fun dateFormat(year: Int, month: Int, day: Int) : String {
        var result = ""
        result =
            if (month <= 9 && day <= 9) year.toString() + "0" + month + "0" + day
            else if (day <= 9) year.toString() + month + "0" + day
            else if (month <= 9) year.toString() + "0" + month + day
            else year.toString() + month + day
        return result
    }

    private fun boxOfficeSearch() {
        prog.visibility = View.VISIBLE
        apiInterface?.getBoxOffice(Constants.KEY, dateSet)?.enqueue(object :Callback, retrofit2.Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                val body = response.body()
                val list : MutableList<DailyBoxOfficeList>? = body?.boxOfficeResult?.dailyBoxOfficeList
                if(list != null) adapter?.setData(list)
                prog.visibility = View.GONE
            }
            override fun onFailure(call: Call<Result>, t: Throwable) {
                prog.visibility = View.GONE
                t.printStackTrace()
            }
        })
    }
}


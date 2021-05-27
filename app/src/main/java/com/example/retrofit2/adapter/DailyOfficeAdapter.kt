package com.example.retrofit2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.R
import com.example.retrofit2.adapter.holder.DailyOfficeHolder
import com.example.retrofit2.network.model.DailyBoxOfficeList

/**
 * Retrofit2
 * Class: DailyOfficeAdapter
 * Created by 한경동 (Joel) on 2021/05/26.
 * Description:
 */
class DailyOfficeAdapter : RecyclerView.Adapter<DailyOfficeHolder>() {

    private var movieList = mutableListOf<DailyBoxOfficeList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyOfficeHolder = DailyOfficeHolder(LayoutInflater.from(parent.context).inflate(R.layout.dailymovie_item, parent, false))

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: DailyOfficeHolder, position: Int) = holder.onBind(movieList[position])

    fun setData(list: MutableList<DailyBoxOfficeList>) {
        this.movieList = list
        notifyDataSetChanged()
    }

}
package com.example.retrofit2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.R
import com.example.retrofit2.adapter.holder.DailyOfficeHolder
import com.example.retrofit2.network.model.Result

/**
 * Retrofit2
 * Class: DailyOfficeAdapter
 * Created by 한경동 (Joel) on 2021/05/26.
 * Description:
 */
class DailyOfficeAdapter(context: Context) : RecyclerView.Adapter<DailyOfficeHolder>() {


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DailyOfficeHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyOfficeHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.dailymovielist_item, parent, false)
        val holder = DailyOfficeHolder(view)
        return holder
    }

}
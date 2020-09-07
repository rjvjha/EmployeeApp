package com.rjvjha.android.employee.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rjvjha.android.employee.R
import com.rjvjha.android.employee.data.model.Employee

class EmployeeListAdapter(private val context: Context, val dataList:ArrayList<Employee>): RecyclerView.Adapter<EmployeeViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder =
        EmployeeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false))

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = dataList[position]
        holder.onBind(employee)
    }

    fun appendData(dataList: List<Employee>) {
        val oldCount = itemCount
        this.dataList.addAll(dataList)
        val currentCount = itemCount
        if (oldCount == 0 && currentCount > 0)
            notifyDataSetChanged()
        else if (oldCount > 0 && currentCount > oldCount)
            notifyItemRangeChanged(oldCount - 1, currentCount - oldCount)
    }


}
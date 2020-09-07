package com.rjvjha.android.employee.ui.home.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rjvjha.android.employee.data.model.Employee
import kotlinx.android.synthetic.main.item_layout.view.*
import okhttp3.internal.ignoreIoExceptions
import java.text.FieldPosition

class EmployeeViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){


   fun onBind (employee: Employee){
       itemView.nameTextView.text = employee.firstName.plus(" " + employee.lastName)
       itemView.emailTextView.text = employee.email
       Glide.with(itemView.context).load(employee.avatar).into(itemView.imageView)
   }


}
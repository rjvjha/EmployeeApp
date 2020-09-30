package com.rjvjha.android.employee.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.rjvjha.android.employee.data.model.Employee

class EmployeeDiffCallback(private val oldList: List<Employee>, private val newList: List<Employee>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val (_,email, firstName,lastName,_) = oldList[oldItemPosition]
        val (_,email1, firstName1,lastName1,_) = newList[newItemPosition]
        return email == email1 && firstName == firstName1 && lastName == lastName1
    }
}
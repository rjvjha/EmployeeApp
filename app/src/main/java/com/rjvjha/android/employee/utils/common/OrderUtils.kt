package com.rjvjha.android.employee.utils.common

import com.rjvjha.android.employee.data.model.Employee
import java.util.*

object OrderUtils {

    fun sortByName(data: List<Employee>?) : List<Employee> {
        return data!!.sortedWith(compareBy { it.firstName })
    }

    fun sortById(data: List<Employee>?)  : List<Employee> {
        return data!!.sortedWith(compareBy { it.id })
    }
}
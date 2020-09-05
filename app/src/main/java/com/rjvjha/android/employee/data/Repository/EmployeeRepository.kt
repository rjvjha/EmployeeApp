package com.rjvjha.android.employee.data.Repository

import com.rjvjha.android.employee.data.local.DatabaseService
import com.rjvjha.android.employee.data.model.Employee
import com.rjvjha.android.employee.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val networkService: NetworkService
) {
    var totalPages:Int = 0

    fun fetchEmployeeList(page:Int):Single<List<Employee>>{
        return networkService.fetchEmployeeListCall(page).map{ it.data }
    }



}
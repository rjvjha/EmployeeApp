package com.rjvjha.android.employee.data.Repository

import com.rjvjha.android.employee.data.local.DatabaseService
import com.rjvjha.android.employee.data.model.Employee
import com.rjvjha.android.employee.data.remote.NetworkService
import com.rjvjha.android.employee.data.remote.response.EmployeeListResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val networkService: NetworkService
) {
    var totalPages:Int = 0

    fun fetchEmployeeList(page:Int):Observable<EmployeeListResponse>{
        return networkService.fetchEmployeeListCall(page)
    }



}
package com.rjvjha.android.employee.data.remote

import com.rjvjha.android.employee.data.model.Employee
import com.rjvjha.android.employee.data.remote.response.EmployeeListResponse
import com.rjvjha.android.employee.data.remote.response.SingleEmployeeResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.LIST_API)
    fun fetchEmployeeListCall(@Query("page") page:Int?):Observable<EmployeeListResponse>

    @GET(Endpoints.SINGLE_USER_API)
    fun fetchSingleEmployeeCall(@Path("id") empId:Int?):Single<SingleEmployeeResponse>

}
package com.rjvjha.android.employee.data.Repository

import android.annotation.SuppressLint
import android.util.Log
import com.rjvjha.android.employee.data.local.db.DatabaseService
import com.rjvjha.android.employee.data.remote.NetworkService
import com.rjvjha.android.employee.data.remote.response.EmployeeListResponse
import com.rjvjha.android.employee.utils.rx.RxSchedulerProvider
import com.rjvjha.android.employee.utils.rx.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {
    var totalPages:Int = 0

    @Inject
    lateinit var schedulerProvider: SchedulerProvider

    fun fetchEmployeeList(page:Int):Observable<EmployeeListResponse>{
        return networkService.fetchEmployeeListCall(page).doOnNext{
            saveLatestRemoteEmployeeListToLocal(it)
        }
    }

    fun fetchSingleEmployee(empId: Int) = networkService.fetchSingleEmployeeCall(empId)

    @SuppressLint("CheckResult")
    private fun saveLatestRemoteEmployeeListToLocal(response: EmployeeListResponse){
        val list = response.data
        databaseService.employeeDao().count().flatMap{
            when (it) {
                0 -> databaseService.employeeDao().insertMany(list)
                6 -> databaseService.employeeDao().insertMany(list)
                else -> Single.just(0)
            }
        }.subscribeOn(schedulerProvider.io())
            .subscribe(
                {
                    Log.d("data in db", "users exist in the table: $it")

                }
                ,{
                    Log.d("data in db", it.toString())

                })
    }

    fun fetchEmployeeListFromLocal() = databaseService.employeeDao().getAllEmployees()

}
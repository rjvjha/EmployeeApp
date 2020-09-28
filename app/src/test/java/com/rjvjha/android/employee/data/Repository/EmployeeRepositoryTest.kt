package com.rjvjha.android.employee.data.Repository

import com.rjvjha.android.employee.data.local.db.DatabaseService
import com.rjvjha.android.employee.data.model.Employee
import com.rjvjha.android.employee.data.model.Organisation
import com.rjvjha.android.employee.data.remote.NetworkService
import com.rjvjha.android.employee.data.remote.Networking
import com.rjvjha.android.employee.data.remote.response.EmployeeListResponse
import com.rjvjha.android.employee.data.remote.response.SingleEmployeeResponse
import com.rjvjha.android.employee.utils.common.FileUtils
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.io.File

@RunWith(MockitoJUnitRunner::class)
class EmployeeRepositoryTest{

    @Mock
    private lateinit var networkService: NetworkService

    @Mock
    private lateinit var databaseService: DatabaseService

    private lateinit var employeeRepository: EmployeeRepository

    @Before
    fun  setup(){
        employeeRepository = EmployeeRepository(networkService,databaseService)
    }

    @Test
    fun fetchEmployeeList_requestFetchEmployeeListCall(){
        val list = listOf(
            Employee(1,"dummy@gmail.com", "Rajeev", "Jha","")
            , Employee(2,"dummy@gmail.com", "Rajeev", "Jha","")
            , Employee(3,"dummy@gmail.com", "Rajeev", "Jha","")
        )

        val employeeListResponse = EmployeeListResponse(1,6,10,2,list)

        doReturn(Observable.just(employeeListResponse))
            .`when`(networkService)
            .fetchEmployeeListCall(1)

        employeeRepository.fetchEmployeeList(1)

        verify(networkService).fetchEmployeeListCall(1)

    }

    @Test
    fun fetchSingleEmployee_requestFetchSingleEmployeeCall(){
        val emp = Employee (2,"dummy@gmail.com", "Dummy", "Jha","")
        val org = Organisation("dummy1", "dummy2","dummy3")
        val empResponse = SingleEmployeeResponse(emp,org)

        doReturn(Single.just(empResponse))
            .`when`(networkService)
            .fetchSingleEmployeeCall(2)

        employeeRepository.fetchSingleEmployee(2)

        verify(networkService).fetchSingleEmployeeCall(2)
    }

}
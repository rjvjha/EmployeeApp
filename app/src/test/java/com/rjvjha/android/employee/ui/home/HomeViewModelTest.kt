package com.rjvjha.android.employee.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.rjvjha.android.employee.data.Repository.EmployeeRepository
import com.rjvjha.android.employee.data.model.Employee
import com.rjvjha.android.employee.data.remote.response.EmployeeListResponse
import com.rjvjha.android.employee.utils.common.Resource
import com.rjvjha.android.employee.utils.network.NetworkHelper
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import utils.rx.TestSchedulerProvider

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var networkHelper: NetworkHelper

    @Mock
    private lateinit var employeeRepository: EmployeeRepository

    @Mock
    private lateinit var messageStringIdObserver: Observer<Resource<Int>>

    @Mock
    private lateinit var empListObserver: Observer<List<Employee>>

    @Mock
    private lateinit var isEmpListFetchingObserver: Observer<Boolean>

    private lateinit var testScheduler: TestScheduler

    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setup(){
        val compositeDisposable = CompositeDisposable()
        testScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(testScheduler)
        homeViewModel = HomeViewModel(testSchedulerProvider, compositeDisposable, networkHelper, employeeRepository)
        homeViewModel.isEmpListFetching().observeForever(isEmpListFetchingObserver)
        homeViewModel.getEmpList().observeForever(empListObserver)
        homeViewModel.messageStringId.observeForever(messageStringIdObserver)
    }

    @Test
    fun givenServerResponse200_whenLaunched_shouldShowEmployeeList(){

        val list = listOf(
            Employee(1,"dummy@gmail.com", "Rajeev", "Jha","")
            , Employee(2,"dummy@gmail.com", "Rajeev", "Jha","")
            , Employee(3,"dummy@gmail.com", "Rajeev", "Jha","")
        )
        val list2 = listOf(
            Employee(4,"dummy@gmail.com", "Rajeev", "Jha","")
            , Employee(5,"dummy@gmail.com", "Rajeev", "Jha","")
            , Employee(6,"dummy@gmail.com", "Rajeev", "Jha","")
            , Employee(7,"dummy@gmail.com", "Rajeev", "Jha","")
            , Employee(8,"dummy@gmail.com", "Rajeev", "Jha","")
        )

        val employeeListResponse1 = EmployeeListResponse(1,6,10,2,list)

        val employeeListResponse2 = EmployeeListResponse(2,6,10,2,list2)

        doReturn(true)
            .`when`(networkHelper)
            .isNetworkConnected()

       doReturn(Observable.just(employeeListResponse1))
            .`when`(employeeRepository).fetchEmployeeList(1)

        doReturn(Observable.just(employeeListResponse2))
            .`when`(employeeRepository).fetchEmployeeList(2)

        val resultList = list.plus(list2)

        homeViewModel.onCreate()
        testScheduler.triggerActions()
        verify(isEmpListFetchingObserver).onChanged(true)
        assert(homeViewModel.getEmpList().value == null)
        verify(empListObserver).onChanged(null)
        verify(empListObserver).onChanged(resultList)
        verify(isEmpListFetchingObserver).onChanged(false)

    }

    @After
    fun teardown(){
        homeViewModel.isEmpListFetching().removeObserver(isEmpListFetchingObserver)
        homeViewModel.getEmpList().removeObserver(empListObserver)
        homeViewModel.messageStringId.removeObserver(messageStringIdObserver)

    }





}
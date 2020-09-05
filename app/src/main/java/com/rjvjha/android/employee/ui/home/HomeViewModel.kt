package com.rjvjha.android.employee.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.rjvjha.android.employee.data.Repository.EmployeeRepository
import com.rjvjha.android.employee.data.model.Employee
import com.rjvjha.android.employee.ui.base.BaseViewModel
import com.rjvjha.android.employee.utils.network.NetworkHelper
import com.rjvjha.android.employee.utils.common.Resource
import com.rjvjha.android.employee.utils.common.Status
import com.rjvjha.android.employee.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val employeeRepository: EmployeeRepository
    ): BaseViewModel(schedulerProvider,compositeDisposable, networkHelper) {

    private val empList: MutableLiveData<Resource<List<Employee>>> = MutableLiveData()

    fun getEmpList(): LiveData<List<Employee>> =
        Transformations.map(empList) { it.data }

    fun isEmpListFetching(): LiveData<Boolean> =
        Transformations.map(empList) { it.status == Status.LOADING }


    override fun onCreate() {
        if (empList.value == null && checkInternetConnection()) {
            empList.postValue(Resource.loading())
            compositeDisposable.add(
                employeeRepository.fetchEmployeeList(1)
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        { empList.postValue(Resource.success(it)) },
                        {
                            handleNetworkError(it)
                            empList.postValue(Resource.error())
                        })
            )
        }

    }

}
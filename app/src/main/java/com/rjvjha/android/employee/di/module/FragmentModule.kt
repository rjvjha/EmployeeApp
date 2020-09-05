package com.rjvjha.android.employee.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.rjvjha.android.employee.data.Repository.EmployeeRepository
import com.rjvjha.android.employee.di.ActivityContext
import com.rjvjha.android.employee.ui.base.BaseFragment
import com.rjvjha.android.employee.ui.home.HomeViewModel
import com.rjvjha.android.employee.utils.network.NetworkHelper
import com.rjvjha.android.employee.utils.ViewModelProviderFactory
import com.rjvjha.android.employee.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = fragment.context!!

    @Provides
    fun provideHomeViewModel(schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable, networkHelper: NetworkHelper, employeeRepository: EmployeeRepository) : HomeViewModel =

        ViewModelProvider(fragment, ViewModelProviderFactory(HomeViewModel::class){
            HomeViewModel(schedulerProvider,compositeDisposable,networkHelper,employeeRepository)
        }).get(HomeViewModel::class.java)
}

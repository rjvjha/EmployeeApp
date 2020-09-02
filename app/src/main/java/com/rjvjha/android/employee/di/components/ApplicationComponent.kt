package com.rjvjha.android.employee.di.components

import android.content.Context
import com.rjvjha.android.employee.EmployeeApplication
import com.rjvjha.android.employee.data.local.DatabaseService
import com.rjvjha.android.employee.data.remote.NetworkService
import com.rjvjha.android.employee.di.ApplicationContext
import com.rjvjha.android.employee.di.module.ApplicationModule
import com.rjvjha.android.employee.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: EmployeeApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable(): CompositeDisposable

}

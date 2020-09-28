package com.rjvjha.android.employee.di.components

import android.content.Context
import com.rjvjha.android.employee.EmployeeApplication
import com.rjvjha.android.employee.data.Repository.EmployeeRepository
import com.rjvjha.android.employee.data.local.db.DatabaseService
import com.rjvjha.android.employee.data.remote.NetworkService
import com.rjvjha.android.employee.di.ApplicationContext
import com.rjvjha.android.employee.di.module.ApplicationModule
import com.rjvjha.android.employee.utils.network.NetworkHelper
import com.rjvjha.android.employee.utils.rx.SchedulerProvider
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

    fun getNetworkService():NetworkService

    fun getEmployeeRepository(): EmployeeRepository

    fun getSchedulerProvider(): SchedulerProvider

    fun getDatabaseService(): DatabaseService


}

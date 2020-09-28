package com.rjvjha.android.employee

import android.app.Application
import com.rjvjha.android.employee.data.local.DatabaseService
import com.rjvjha.android.employee.data.remote.NetworkService
import com.rjvjha.android.employee.di.components.ApplicationComponent
import com.rjvjha.android.employee.di.components.DaggerApplicationComponent
import com.rjvjha.android.employee.di.module.ApplicationModule
import javax.inject.Inject

class EmployeeApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        setupDependencies()
    }

    private fun setupDependencies(){
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

    // Needed to replace the component with a test specific one
    fun setComponent(applicationComponent: ApplicationComponent) {
        this.applicationComponent = applicationComponent
    }

}
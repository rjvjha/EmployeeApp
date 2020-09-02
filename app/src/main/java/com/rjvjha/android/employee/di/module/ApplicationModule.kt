package com.rjvjha.android.employee.di.module
import android.content.Context
import com.rjvjha.android.employee.EmployeeApplication
import com.rjvjha.android.employee.di.ApplicationContext
import com.rjvjha.android.employee.di.DatabaseInfo
import com.rjvjha.android.employee.di.NetworkInfo
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ApplicationModule(private val application: EmployeeApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context = application


    @Provides
    fun providesCompositeDisposable():CompositeDisposable = CompositeDisposable()

}

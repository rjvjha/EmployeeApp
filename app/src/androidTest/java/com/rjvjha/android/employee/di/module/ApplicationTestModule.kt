package com.rjvjha.android.employee.di.module

import android.app.Application
import android.content.Context
import com.rjvjha.android.employee.BuildConfig
import com.rjvjha.android.employee.EmployeeApplication
import com.rjvjha.android.employee.data.remote.NetworkService
import com.rjvjha.android.employee.data.remote.Networking
import com.rjvjha.android.employee.di.ApplicationContext
import com.rjvjha.android.employee.di.TempDirectory
import com.rjvjha.android.employee.utils.common.FileUtils
import com.rjvjha.android.employee.utils.network.NetworkHelper
import com.rjvjha.android.employee.utils.rx.RxSchedulerProvider
import com.rjvjha.android.employee.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationTestModule(private  val application: EmployeeApplication) {


    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    @TempDirectory
    fun provideTempDirectory() = FileUtils.getDirectory(application,"temp")

    @Provides
    fun providesCompositeDisposable():CompositeDisposable = CompositeDisposable()


    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()


    @Singleton
    @Provides
    fun providesNetworkService():NetworkService =
        Networking.create (
            BuildConfig.BASE_URL,
            application.cacheDir,
            10*1024*1024 // 10MB
        )

}
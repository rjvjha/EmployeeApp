package com.rjvjha.android.employee.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.rjvjha.android.employee.di.ActivityContext
import com.rjvjha.android.employee.ui.base.BaseActivity
import com.rjvjha.android.employee.ui.main.MainViewModel
import com.rjvjha.android.employee.utils.network.NetworkHelper
import com.rjvjha.android.employee.utils.ViewModelProviderFactory
import com.rjvjha.android.employee.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideMainViewModel(schedulerProvider: SchedulerProvider,compositeDisposable: CompositeDisposable, networkHelper: NetworkHelper) : MainViewModel =

        ViewModelProvider(activity,ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(schedulerProvider,compositeDisposable,networkHelper)
        }).get(MainViewModel::class.java)
}
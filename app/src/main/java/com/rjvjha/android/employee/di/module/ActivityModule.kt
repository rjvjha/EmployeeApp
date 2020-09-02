package com.rjvjha.android.employee.di.module

import android.app.Activity
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.rjvjha.android.employee.di.ActivityContext
import com.rjvjha.android.employee.ui.base.BaseActivity
import com.rjvjha.android.employee.ui.main.MainViewModel
import com.rjvjha.android.employee.utils.NetworkHelper
import com.rjvjha.android.employee.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideMainViewModel(compositeDisposable: CompositeDisposable, networkHelper: NetworkHelper) : MainViewModel =

        ViewModelProvider(activity,ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(compositeDisposable,networkHelper)
        }).get(MainViewModel::class.java)
}
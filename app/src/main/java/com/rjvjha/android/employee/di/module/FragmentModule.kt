package com.rjvjha.android.employee.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rjvjha.android.employee.di.ActivityContext
import com.rjvjha.android.employee.ui.base.BaseFragment
import com.rjvjha.android.employee.ui.home.HomeViewModel
import com.rjvjha.android.employee.ui.main.MainViewModel
import com.rjvjha.android.employee.utils.NetworkHelper
import com.rjvjha.android.employee.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = fragment.context!!

    @Provides
    fun provideHomeViewModel(compositeDisposable: CompositeDisposable, networkHelper: NetworkHelper) : HomeViewModel =

        ViewModelProvider(fragment, ViewModelProviderFactory(HomeViewModel::class){
            HomeViewModel(compositeDisposable,networkHelper)
        }).get(HomeViewModel::class.java)
}

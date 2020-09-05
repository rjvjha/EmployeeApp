package com.rjvjha.android.employee.ui.main

import androidx.lifecycle.MutableLiveData
import com.rjvjha.android.employee.ui.base.BaseViewModel
import com.rjvjha.android.employee.utils.network.NetworkHelper
import com.rjvjha.android.employee.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
): BaseViewModel(schedulerProvider,compositeDisposable, networkHelper) {


    val data = MutableLiveData<String>()

    override fun onCreate() {
    }
}
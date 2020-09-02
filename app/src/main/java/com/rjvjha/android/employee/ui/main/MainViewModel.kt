package com.rjvjha.android.employee.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rjvjha.android.employee.ui.base.BaseViewModel
import com.rjvjha.android.employee.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.newFixedThreadPoolContext

class MainViewModel(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper): BaseViewModel(compositeDisposable, networkHelper) {


    val data = MutableLiveData<String>()

    override fun onCreate() {
        data.postValue("MainViewModel")
    }
}
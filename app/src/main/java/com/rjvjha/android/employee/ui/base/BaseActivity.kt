package com.rjvjha.android.employee.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.rjvjha.android.employee.EmployeeApplication
import com.rjvjha.android.employee.R
import com.rjvjha.android.employee.di.components.ActivityComponent
import com.rjvjha.android.employee.di.components.DaggerActivityComponent
import com.rjvjha.android.employee.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity< VM: BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObservers()
        setupView(savedInstanceState)
        viewModel.onCreate()
    }

    protected open fun setupObservers(){
        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

    }

    fun showMessage(msg : String) = Toast.makeText(applicationContext, msg,Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId : Int) = showMessage(resources.getString(resId))

    private fun buildActivityComponent() = DaggerActivityComponent.builder()
            .applicationComponent((application as EmployeeApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()


    @LayoutRes
    protected abstract fun provideLayoutId() : Int

    protected abstract fun setupView(savedInstanceState: Bundle?)

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

}
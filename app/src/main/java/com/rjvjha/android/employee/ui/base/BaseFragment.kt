package com.rjvjha.android.employee.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.rjvjha.android.employee.EmployeeApplication
import com.rjvjha.android.employee.di.components.ActivityComponent
import com.rjvjha.android.employee.di.components.DaggerFragmentComponent
import com.rjvjha.android.employee.di.components.FragmentComponent
import com.rjvjha.android.employee.di.module.FragmentModule
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
        setupObservers()
        viewModel.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(provideLayoutId(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }

    protected open fun setupObservers(){
        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

    }

    fun showMessage(msg : String) = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId : Int) = showMessage(resources.getString(resId))

    private fun buildFragmentComponent() = DaggerFragmentComponent.builder()
        .applicationComponent((context!!.applicationContext as EmployeeApplication).applicationComponent)
        .fragmentModule(FragmentModule(this))
        .build()

    @LayoutRes
    protected abstract fun provideLayoutId() : Int

    protected abstract fun setupView(view : View)

    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)
}
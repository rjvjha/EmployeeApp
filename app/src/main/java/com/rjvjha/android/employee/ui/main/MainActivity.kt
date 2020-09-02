package com.rjvjha.android.employee.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.rjvjha.android.employee.R
import com.rjvjha.android.employee.di.components.ActivityComponent
import com.rjvjha.android.employee.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
    //        TODO("Not yet implemented")
    }


    override fun setupObservers() {
        super.setupObservers()
        viewModel.data.observe(this, Observer {
            tv_message.text = it
        })
    }



    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}
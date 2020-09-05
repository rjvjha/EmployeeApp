package com.rjvjha.android.employee.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.rjvjha.android.employee.R
import com.rjvjha.android.employee.di.components.ActivityComponent
import com.rjvjha.android.employee.ui.base.BaseActivity
import com.rjvjha.android.employee.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
        addHomeFragment()
    }

    private fun addHomeFragment(){
        supportFragmentManager.findFragmentByTag(HomeFragment.TAG) ?: supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, HomeFragment.newInstance(), HomeFragment.TAG)
            .commitAllowingStateLoss()
    }

    override fun setupObservers() {
        super.setupObservers()
    }



    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}
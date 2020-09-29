package com.rjvjha.android.employee.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.work.*
import com.rjvjha.android.employee.R
import com.rjvjha.android.employee.di.components.ActivityComponent
import com.rjvjha.android.employee.ui.base.BaseActivity
import com.rjvjha.android.employee.ui.home.HomeFragment
import com.rjvjha.android.employee.work.SaveEmployeeWorkerClass
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {
        addHomeFragment()
        setupWorkManager()
    }

    private fun setupWorkManager() {
        // constraints
        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .setRequiresDeviceIdle(true).build()

        // One time workRequest
        val workRequest = OneTimeWorkRequest.Builder(SaveEmployeeWorkerClass::class.java)
            .setInitialDelay(1,TimeUnit.MINUTES)
            .build()

        // periodic workRequest
        val periodicWork = PeriodicWorkRequest.Builder(SaveEmployeeWorkerClass::class.java,1,TimeUnit.HOURS)

        WorkManager.getInstance(this).enqueue(workRequest)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workRequest.id)
            .observe(this, Observer { workInfo ->
                if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
                    //Toast
                    showMessage("Work Successful")
                }
            })
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
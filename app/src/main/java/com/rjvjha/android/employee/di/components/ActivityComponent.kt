package com.rjvjha.android.employee.di.components

import com.rjvjha.android.employee.di.ActivityScope
import com.rjvjha.android.employee.di.module.ActivityModule
import com.rjvjha.android.employee.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface  ActivityComponent {

    fun inject(activity: MainActivity)
}

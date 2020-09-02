package com.rjvjha.android.employee.di.components

import com.rjvjha.android.employee.di.FragmentScope
import com.rjvjha.android.employee.di.module.FragmentModule
import com.rjvjha.android.employee.ui.home.HomeFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment)
}
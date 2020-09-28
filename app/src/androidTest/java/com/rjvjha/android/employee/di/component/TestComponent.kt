package com.rjvjha.android.employee.di.component

import android.content.Context
import com.rjvjha.android.employee.di.ApplicationContext
import com.rjvjha.android.employee.di.components.ApplicationComponent
import com.rjvjha.android.employee.di.module.ApplicationTestModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationTestModule::class])
interface TestComponent:ApplicationComponent{

}
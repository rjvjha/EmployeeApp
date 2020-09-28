package com.rjvjha.android.employee

import android.content.Context
import androidx.test.espresso.DaggerBaseLayerComponent
import com.rjvjha.android.employee.di.component.DaggerTestComponent
import com.rjvjha.android.employee.di.component.TestComponent
import com.rjvjha.android.employee.di.components.DaggerActivityComponent
import com.rjvjha.android.employee.di.module.ApplicationTestModule
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class TestComponentRule(private val context: Context): TestRule {

    private var testComponent: TestComponent? = null

    fun getContext() = context

    private fun setupDaggerTestComponentInApplication(){
        val application = context.applicationContext as EmployeeApplication
        testComponent = DaggerTestComponent.builder()
            .applicationTestModule(ApplicationTestModule(application)).
            build()
        application.setComponent(testComponent!!)
    }


    override fun apply(base: Statement, description: Description?): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                try {
                    setupDaggerTestComponentInApplication()
                    base.evaluate()
                } finally {
                    testComponent = null
                }
            }
        }
    }
}
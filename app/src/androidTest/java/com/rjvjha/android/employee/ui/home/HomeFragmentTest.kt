package com.rjvjha.android.employee.ui.home

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import com.rjvjha.android.employee.R
import com.rjvjha.android.employee.TestComponentRule
import com.rjvjha.android.employee.data.Repository.EmployeeRepository
import com.rjvjha.android.employee.utils.RvMatcher.atPositionOnView
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

class HomeFragmentTest{

    private val component = TestComponentRule(InstrumentationRegistry.getInstrumentation().targetContext)

    private lateinit var employeeRepository:EmployeeRepository

    @get:Rule
    val chain = RuleChain.outerRule(component)

    @Before
    fun setup(){
        employeeRepository = component.testComponent!!.getEmployeeRepository()
    }

    @Test
    fun testEmployeeListAvailableFirstIsGeorgeBluth(){
        launchFragmentInContainer<HomeFragment>(Bundle(), R.style.AppTheme)
        onView(withId(R.id.recyclerView))
            .check(matches(ViewMatchers.isDisplayed()))
        Thread.sleep(200)
        onView(withId(R.id.recyclerView)).
            check(matches(atPositionOnView(0, withText("George Bluth"), R.id.nameTextView)))



    }
}
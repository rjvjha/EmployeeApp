package com.rjvjha.android.employee.ui

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.rjvjha.android.employee.R
import com.rjvjha.android.employee.TestComponentRule
import com.rjvjha.android.employee.ui.main.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

class MainActivityTest {

    private val component = TestComponentRule(InstrumentationRegistry.getInstrumentation().targetContext)

    private val main = IntentsTestRule(MainActivity::class.java, false, false)

    @get:Rule
    val chain = RuleChain.outerRule(component).around(main)

    @Before
    fun setup() {

    }

    @Test
    fun testViewsDisplay(){
        main.launchActivity(Intent(component.getContext(),MainActivity::class.java))
        onView(withId(R.id.recyclerView))
            .check(matches(isDisplayed()))

    }
}
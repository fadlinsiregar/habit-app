package com.dicoding.habitapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dicoding.habitapp.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Habit (+), the AddHabitActivity displayed
@RunWith(AndroidJUnit4ClassRunner::class)
class HabitActivityTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(HabitListActivity::class.java)
    }

    @Test
    fun assertAddHabitToAddHabitActivity() {
        onView(withId(R.id.fab)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.fab)).perform(click())
        onView(withId(R.id.add_ed_title)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.add_ed_minutes_focus)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_save)).check(ViewAssertions.matches(isDisplayed()))
    }
}
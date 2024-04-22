package com.draja.marsrover

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.draja.marsrover.di.stubAppModule
import com.draja.marsrover.ui.result.ResultFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

@RunWith(AndroidJUnit4::class)
class ResultFragmentTest {

    @Before
    fun setUp() {
        stopKoin()
        startKoin {
            modules(stubAppModule)
        }
    }

    @Test
    fun all_view_is_displayed() {
        launchFragmentInContainer<ResultFragment>()

        Espresso.onView(ViewMatchers.withId(R.id.result_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.result_screen_title)))

        Espresso.onView(ViewMatchers.withId(R.id.result_coordinate_x_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.result_coordinate_x)))

        Espresso.onView(ViewMatchers.withId(R.id.result_coordinate_x_value))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))

        Espresso.onView(ViewMatchers.withId(R.id.result_coordinate_y_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.result_coordinate_y)))

        Espresso.onView(ViewMatchers.withId(R.id.result_coordinate_y_value))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(ViewMatchers.withText("2")))

        Espresso.onView(ViewMatchers.withId(R.id.result_orientation_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.result_orientation)))

        Espresso.onView(ViewMatchers.withId(R.id.result_orientation_value))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(ViewMatchers.withText("N")))
    }
}
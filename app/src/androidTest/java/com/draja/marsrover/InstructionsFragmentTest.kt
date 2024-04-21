package com.draja.marsrover

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.draja.marsrover.ui.instructions.InstructionsFragment
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not


@RunWith(AndroidJUnit4::class)
class InstructionsFragmentTest {

    @Test
    fun all_view_is_displayed() {
        launchFragmentInContainer<InstructionsFragment>()

        onView(withId(R.id.main_screen_title))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.main_screen_title)))

        onView(withId(R.id.mars_title))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.mars_dimension_title)))

        onView(withId(R.id.marsX))
            .check(matches(isDisplayed()))

        onView(withId(R.id.marsY))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rover_position_title))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.rover_position_title)))

        onView(withId(R.id.roverX))
            .check(matches(isDisplayed()))

        onView(withId(R.id.roverY))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rover_orientation_title))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.rover_orientation_title)))

        onView(withId(R.id.rover_commands_title))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.rover_commands_title)))

        onView(withId(R.id.rover_commands_input))
            .check(matches(isDisplayed()))

        onView(withId(R.id.send_button))
            .check(matches(isDisplayed()))
    }
}
package com.br.wcabral.kotlin.android.githubcompose

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.br.wcabral.kotlin.android.githubcompose.ui.feature.main.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {


    @Rule
    @JvmField
    var composeTestRule: ComposeContentTestRule = createAndroidComposeRule<MainActivity>()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun counterChange() {


        repeat(5) {

            composeTestRule.onNodeWithText("Up")
                .performClick()
        }

        composeTestRule.onNodeWithTag("Content")
            .assert(hasText("6"))

        repeat(5) {

            composeTestRule.onNodeWithTag("downbutton")
                .performClick()
        }

        composeTestRule.onNodeWithTag("Content")
            .assert(hasText("1"))
    }


    @Test
    fun list() {


        composeTestRule.onNodeWithTag("mylist")
            .performScrollToIndex(26)


        composeTestRule.onNodeWithText("I am number 26")
            .onAncestors()
            .onFirst()
            .onChildren()
            .filterToOne(hasTestTag("desc"))
            .assert(hasText("Desc 26"))


        composeTestRule.onNodeWithText("I am number 26")
            .onParent()
            .onChildren()
            .filterToOne(hasTestTag("desc"))
            .assert(hasText("Desc 26"))
    }


    @OptIn(ExperimentalTestApi::class)
    @Test
    fun async() {


        composeTestRule.onNodeWithText("Up")
            .performClick()

        composeTestRule.waitUntilExactlyOneExists(hasTestTag("Content").and(hasText("2")), 5000L)

    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun asyncApiCall() {


        composeTestRule.waitUntilAtLeastOneExists(hasTestTag("githublist"), 10000L)

        composeTestRule.onNodeWithTag("githublist")
            .onChildren()
            .filterToOne(hasTestTag("position=3"))
            .performClick()

        composeTestRule.waitUntilAtLeastOneExists(hasTestTag("avatar"), 10000L)

    }
}

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

    }


    @Test
    fun list() {


        composeTestRule.onNodeWithTag("mylist")
            .performScrollToIndex(20)



        composeTestRule.onNodeWithText("I am number 9").assertIsDisplayed()
            .assert(hasText("I am number 9"))
            .assertExists()

    }
}

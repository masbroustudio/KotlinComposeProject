package com.yudhae.submissioncompose

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.yudhae.submissioncompose.ui.MainActivity
import com.yudhae.submissioncompose.ui.TvShows
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TvShowEndToEndTest {

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()


    @Before
    fun setUp() {
        composeRule.activity.setContent {
            TvShows()
        }
    }

    @Test
    fun homeShowListingScreenTest() {
        composeRule.onRoot(useUnmergedTree = true).printToLog("Tag")
        composeRule.onNodeWithText("Home", useUnmergedTree = true).assertIsDisplayed()
        composeRule.onNodeWithText("Home").performClick()
        composeRule.onNode(hasText("My TV Show"))
    }

    @Test
    fun favoriteShowScreenTest() {
        composeRule.onNodeWithText("Favorite", useUnmergedTree = true).assertIsDisplayed()
        composeRule.onNodeWithText("Favorite").performClick()
        composeRule.onNode(hasText("My Favorite TV Show"))
    }

    @Test
    fun settingScreenTest() {
        composeRule.onNodeWithText("About", useUnmergedTree = true).assertIsDisplayed()

        composeRule.onNodeWithText("About").performClick()

        composeRule.onNode(hasText("About Me"))

        composeRule.onNodeWithText("About the App", useUnmergedTree = true).assertIsDisplayed()

        composeRule.onNodeWithText("Version 1.0", useUnmergedTree = true).assertIsDisplayed()

    }

}
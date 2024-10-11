package com.example.composetesting.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class DialogComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogGetATrue_thenShowDialog(){
        composeTestRule.setContent {
            AddTaskDialog(show = true, onDismiss = { }, onTaskAdded = {})
        }
        composeTestRule.onNodeWithTag("dialog").assertIsDisplayed()
    }

    @Test
    fun whenDialogGetATrue_thenDoNotShowDialog(){
        composeTestRule.setContent {
            AddTaskDialog(show = false, onDismiss = { }, onTaskAdded = {})
        }
        composeTestRule.onNodeWithTag("dialog").assertDoesNotExist()
    }
}
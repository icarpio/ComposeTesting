package com.example.composetesting.components

import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.action.ViewActions.swipeDown
import org.junit.Rule
import org.junit.Test

class TestComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest(){
        composeTestRule.setContent {
            TestComponent()
        }
        //Finder
        composeTestRule.onNodeWithText("Hello", ignoreCase = true) // a través de texto
        composeTestRule.onNodeWithTag("component1")// a través de tag
        composeTestRule.onAllNodesWithContentDescription("imageTest") // a través de contentDescription

        composeTestRule.onAllNodesWithText(":")
        composeTestRule.onAllNodesWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

        //Actions
        composeTestRule.onNodeWithText("Hello", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("a").onFirst().performClick()
        composeTestRule.onNodeWithText("Hello").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("Hello").performScrollTo() //Scroll dentro del componente
        composeTestRule.onNodeWithText("Hello").performImeAction() //permite simular la acción de presionar el botón "Enviar" o "Hecho" en el teclado virtual.
        composeTestRule.onNodeWithText("Hello").performTextClearance()
        composeTestRule.onNodeWithText("Hello").performTextInput("He") // busca un nodo con el texto "Hello" y luego simula la entrada de texto "He" en ese nodo. Es como si el usuario hubiera escrito "He" en el campo de texto.
        composeTestRule.onNodeWithText("Hello").performTextReplacement("He") // este método permite reemplazar el texto actual en un campo de texto o un nodo que admite entrada de texto.

        //Assertions
        composeTestRule.onNodeWithText("Hello").assertExists() //Si existe
        composeTestRule.onNodeWithText("Hello").assertDoesNotExist() //No existe
        composeTestRule.onNodeWithText("Hello").assertContentDescriptionEquals("visualIcon")
        composeTestRule.onNodeWithText("Hello").assertContentDescriptionContains("visualIcon")
        composeTestRule.onNodeWithText("Hello").assertIsDisplayed() //si es visible, estos métodos se utilizan para verificar la visibilidad de un nodo en la pantalla.
        composeTestRule.onNodeWithText("Hello").assertIsNotDisplayed() //si no es visible
        composeTestRule.onNodeWithText("Hello").assertIsEnabled()
        composeTestRule.onNodeWithText("Hello").assertIsNotEnabled() // Este método verifica si el nodo con el texto "" no está habilitado o no es interactuable.
        composeTestRule.onNodeWithText("Hello").assertIsSelected() // Este método verifica si el nodo con el texto "" está seleccionado.
        composeTestRule.onNodeWithText("Hello").assertIsNotSelected() // Este método verifica si el nodo con el texto "" no está seleccionado.
        composeTestRule.onNodeWithText("Hello").assertIsNotFocused() // Este método verifica si el nodo con el texto "" no tiene foco.
        composeTestRule.onNodeWithText("Hello").assertIsOn() //Este método verifica si el nodo con el texto "" está en un estado "on" o activo, como por ejemplo un switch o un botón de toggle que está activado.
        composeTestRule.onNodeWithText("Hello").assertTextEquals("ello")
        composeTestRule.onNodeWithText("Hello").assertTextContains("Hello")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsUserName(){
        composeTestRule.setContent {
            TestComponent()
        }
        composeTestRule.onNodeWithText("UserName", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("UserName")
    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting(){
        composeTestRule.setContent {
            TestComponent()
        }
        composeTestRule.onNodeWithTag("textFieldName").performTextClearance()
        composeTestRule.onNodeWithTag("textFieldName").performTextInput("UserName")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas UserName")
    }



}
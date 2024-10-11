package com.example.composetesting.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun TestComponent(){
    var name by rememberSaveable { mutableStateOf("UserName") }

   Column(Modifier.fillMaxSize()) {
       TextField(value = name, onValueChange = {name = it}, modifier = Modifier.testTag("textFieldName"))
       Text(text = "Te llamas $name", modifier = Modifier.testTag("textGreeting"))
       //Text(text = "World", Modifier.testTag("component2"))
       Image(Icons.Default.AddCircle, contentDescription = "imageTest")
   }
}
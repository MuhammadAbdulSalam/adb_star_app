package com.adbsalam.star.ui.uiutil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun FullScreenLoadingView(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}


@Composable
fun FullScreenColumn(composable: @Composable()()-> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        composable()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextViewWithEndIconComposable(initialValue: String){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    OutlinedTextField(
        value = textState.value,
        label = {Text(initialValue)},
        onValueChange = { textState.value = it },
        trailingIcon = {
            Icon(Icons.Filled.Clear, contentDescription = null)
        }
    )
}

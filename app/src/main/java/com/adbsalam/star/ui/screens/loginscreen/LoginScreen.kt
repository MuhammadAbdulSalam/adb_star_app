package com.adbsalam.star.ui.screens.loginscreen

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.adbsalam.star.ui.uiutil.FullScreenColumn
import com.adbsalam.star.ui.uiutil.TextViewWithEndIconComposable
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel

@Composable
fun LoginScreenCompose(navController: NavController){
    var userNameState = TextViewModel("username", remember { mutableStateOf(TextFieldValue()) })
    var passwordState = TextViewModel("password", remember { mutableStateOf(TextFieldValue()) })

    FullScreenColumn {
        TextViewWithEndIconComposable(userNameState)
        TextViewWithEndIconComposable(passwordState)
        Button(onClick = {

        }) {

        }
    }


}
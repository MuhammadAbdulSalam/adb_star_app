package com.adbsalam.star.ui.screens.loginscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.adbsalam.star.ui.uiutil.FullScreenColumn
import com.adbsalam.star.ui.uiutil.TextViewWithEndIconComposable

@Composable
fun LoginScreenCompose(navController: NavController){
    FullScreenColumn {
        TextViewWithEndIconComposable("Username")
        TextViewWithEndIconComposable("Password")
    }
}
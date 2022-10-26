package com.adbsalam.star.ui.uiutil.uidatamodels

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue

data class TextViewModel (
    var initialValue: String = "",
    var stateText: MutableState<TextFieldValue>,
    var textInitiated:Boolean = false,
    ){
    fun isErrorText(): Boolean {
       return when{
            stateText.value.text.isBlank() || stateText.value.text.isEmpty()  -> true
            else -> false
        }
    }

    fun getErrorMessage(): String{
        return when{
            stateText.value.text.isBlank() -> "Cannot be left blank"
            stateText.value.text.isEmpty() -> "Please enter text"
            else -> ""
        }
    }
}
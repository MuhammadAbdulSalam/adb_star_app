package com.adbsalam.star.ui.uiutil.uidatamodels

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.*

data class TextViewModel (
    var initialValue: String = "",
    var stateText: MutableState<TextFieldValue>? =  null,
    var textInitiated:Boolean = false,
    var textFormat: TextFormat = TextFormat.TEXT
    ){
    fun isErrorText(): Boolean {
       return when{
            stateText?.value?.text?.isBlank() == true || stateText?.value?.text?.isEmpty() == true -> true
            else -> false
        }
    }

    fun getErrorMessage(): String{
        return when{
            stateText?.value?.text?.isBlank() == true -> "cannot be left blank"
            stateText?.value?.text?.isEmpty() == true-> "please enter text"
            else -> ""
        }
    }

    fun showKeyboardType(): KeyboardOptions{
        return when (textFormat){
            TextFormat.NUMBERS_ONLY -> KeyboardOptions(capitalization = KeyboardCapitalization.None, autoCorrect = false, keyboardType = KeyboardType.Number, imeAction = ImeAction.Next)
            TextFormat.TEXT_ALL_CAPS -> KeyboardOptions(capitalization = KeyboardCapitalization.Characters, autoCorrect = false, keyboardType = KeyboardType.Text, imeAction = ImeAction.Next)
            else -> KeyboardOptions(capitalization = KeyboardCapitalization.None, autoCorrect = false, keyboardType = KeyboardType.Text, imeAction = ImeAction.Next)
        }
    }


    fun getVisualTransformation(): VisualTransformation{
        return when(textFormat){
            TextFormat.PASSWORD -> PasswordVisualTransformation()
            else -> VisualTransformation.None
        }
    }

    enum class TextFormat{
        TEXT,
        TEXT_ALL_CAPS,
        NUMBERS_ONLY,
        PASSWORD
    }
}
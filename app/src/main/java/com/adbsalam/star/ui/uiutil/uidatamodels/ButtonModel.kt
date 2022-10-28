package com.adbsalam.star.ui.uiutil.uidatamodels

import androidx.compose.ui.Alignment


data class ButtonModel(
    var buttonText: String = "",
    var alignment: Alignment = Alignment.Center,
    var onClickListener: ()-> Unit = {},
    var isTextButton: Boolean = false
)

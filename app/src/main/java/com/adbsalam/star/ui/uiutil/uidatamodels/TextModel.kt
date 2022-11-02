package com.adbsalam.star.ui.uiutil.uidatamodels

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TextModel(
    val text: String,
    val textType: TextType = TextType.CONTENT

){
    enum class TextType(val fontWeight: FontWeight, val fontSize: TextUnit){
        HEADING(FontWeight.Bold, 24.sp),
        SUB_HEADING(FontWeight.Bold, 16.sp),
        CONTENT(FontWeight.Normal, 14.sp),

    }

}
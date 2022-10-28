package com.adbsalam.star.ui.uiutil.uidatamodels

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ImageModel(
    var resource: Int,
    var contentDescription: String,
    var height: Dp = 60.dp,
    var width: Dp = 60.dp
)
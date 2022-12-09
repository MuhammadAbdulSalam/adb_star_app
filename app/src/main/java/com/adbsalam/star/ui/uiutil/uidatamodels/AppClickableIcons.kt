package com.adbsalam.star.ui.uiutil.uidatamodels

import androidx.compose.ui.graphics.vector.ImageVector

data class AppClickableIcons(val icon: ImageVector, val onClick: () -> Unit = {})

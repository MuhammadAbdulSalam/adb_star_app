package com.adbsalam.star.ui.uiutil

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource



enum class ScrollState(){
    NO_SCROLL,
    SCROLL_UP,
    SCROLL_DOWN
}


@Composable
fun getNestedScrollConnection(scrollDirectionState: MutableState<ScrollState>)=  remember {
    object : NestedScrollConnection {
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            val delta = available.y
            val direction = if(delta> 0f) ScrollState.SCROLL_DOWN else ScrollState.SCROLL_UP
            if(delta> 10f || delta < -10f){
                if(scrollDirectionState.value != direction){
                    scrollDirectionState.value = direction
                }
            }
            return Offset.Zero
        }
    }
}
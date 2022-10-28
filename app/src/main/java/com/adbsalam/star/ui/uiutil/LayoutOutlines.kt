package com.adbsalam.star.ui.uiutil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel

@Composable
fun FullScreenLoadingView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun FullScreenColumn(composable: @Composable() () -> Unit, verticalArrangement: Arrangement.Vertical, horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally) {
    Column(
        modifier = Modifier.fillMaxSize().padding(all = 20.dp),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
    ) {
        composable()
    }
}

@Composable
fun LinearLayoutCompose(modelView: List<Any>) {
    CompactColumn {
        modelView.forEach { model ->
            when(model){
                is TextViewModel -> TextViewWithEndIconComposable(model)
                is ButtonModel -> if (model.isTextButton) AppClickableText( model) else AppButton(model)
            }
        }
    }
}

@Composable
fun CompactColumn(composable: @Composable() () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        composable()
    }
}

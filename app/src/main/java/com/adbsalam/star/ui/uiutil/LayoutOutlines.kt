package com.adbsalam.star.ui.uiutil

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextModel
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
fun FullScreenColumn(verticalArrangement: Arrangement.Vertical, horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally, composable: @Composable() () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
    ) {
        composable()
    }
}

@Composable
fun NavigationFragmentColumn( verticalArrangement: Arrangement.Vertical, horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally, composable: @Composable() () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 30.dp, end = 20.dp, bottom = 20.dp),
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
                is TextModel -> AppText(appTextModel = model)
                is ButtonModel -> if (model.isTextButton) AppClickableText( model) else AppButton(model)
            }
        }
    }
}

@Composable
fun CompactColumn(modifier: Modifier = Modifier.fillMaxWidth(), composable: @Composable() () -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        composable()
    }
}

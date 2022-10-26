package com.adbsalam.star.ui.uiutil

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.red
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
fun FullScreenColumn(composable: @Composable() () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        composable()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextViewWithEndIconComposable(textViewDataModel: TextViewModel) {
    Column(modifier = Modifier.fillMaxWidth().padding(all = 10.dp)) {
        var textState = textViewDataModel.stateText
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textState.value,
            label = { Text(textViewDataModel.initialValue) },
            onValueChange = {
                textState.value = it
                textViewDataModel.textInitiated = true
            },
            isError = textViewDataModel.textInitiated && textViewDataModel.isErrorText(),
            trailingIcon = {
                IconButton(onClick = {
                    textState.value = TextFieldValue()
                    textViewDataModel.textInitiated = false
                }
                ) {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = "",
                    )
                }
            }
        )
        if (textViewDataModel.textInitiated && textViewDataModel.isErrorText()) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                ){
                Text(
                    text = textViewDataModel.getErrorMessage(),
                    modifier = Modifier.align(Alignment.TopEnd),
                    textAlign = TextAlign.End,
                    color = Color.Red,
                    fontSize = 12.sp,
                )
            }
        }
    }
}
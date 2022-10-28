package com.adbsalam.star.ui.uiutil

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adbsalam.star.ui.theme.Purple40
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.ImageModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel



@Composable
fun AppClickableText(buttonModel: ButtonModel){
    ClickableText(
        modifier = Modifier.padding(vertical = 10.dp),
        text = AnnotatedString(buttonModel.buttonText),
        onClick = { buttonModel.onClickListener() },
        style = TextStyle(color = Purple40 , fontSize = 20.sp)
    )
}

@Composable
fun AppButton(buttonModel: ButtonModel){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier.align(Alignment.End).padding(vertical = 10.dp),
            onClick = {buttonModel.onClickListener()}
        ) {
            Text(text = buttonModel.buttonText,)
        }
    }
}

@Composable
fun AppImageView(imageModel: ImageModel){
    val image: Painter = painterResource(id = imageModel.resource)
    Image(
        painter = image,
        contentDescription = "",
        modifier = Modifier.height(imageModel.height).width(imageModel.width)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextViewWithEndIconComposable(textViewDataModel: TextViewModel) {
    textViewDataModel.stateText = remember { mutableStateOf(TextFieldValue()) }
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
        var textState = textViewDataModel.stateText
        textState?.value?.let {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = it,
                label = { Text(textViewDataModel.initialValue) },
                onValueChange = {
                    textState?.value = it
                    textViewDataModel.textInitiated = true
                },
                keyboardOptions = textViewDataModel.showKeyboardType(),
                visualTransformation = textViewDataModel.getVisualTransformation(),
                isError = textViewDataModel.textInitiated && textViewDataModel.isErrorText(),
                trailingIcon = {
                    IconButton(onClick = {
                        textState?.value = TextFieldValue()
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
        }
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
package com.adbsalam.star.ui.uiutil

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adbsalam.star.R
import com.adbsalam.star.ui.theme.Purple40
import com.adbsalam.star.ui.theme.Purple80
import com.adbsalam.star.ui.uiutil.uidatamodels.*
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch


@Composable
fun AppClickableText(buttonModel: ButtonModel) {
    ClickableText(
        modifier = Modifier.padding(vertical = 10.dp),
        text = AnnotatedString(buttonModel.buttonText),
        onClick = { buttonModel.onClickListener() },
        style = TextStyle(color = Purple40, fontSize = 20.sp)
    )
}

@Composable
fun AppButton(buttonModel: ButtonModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .align(if (buttonModel.alignment == Alignment.Center) Alignment.CenterHorizontally else Alignment.End)
                .padding(vertical = 10.dp),
            onClick = { buttonModel.onClickListener() }
        ) {
            Text(text = buttonModel.buttonText)
        }
    }
}

@Composable
fun AppImageView(imageModel: ImageModel) {
    val image: Painter = painterResource(id = imageModel.resource)
    Image(
        painter = image,
        contentDescription = "",
        modifier = Modifier
            .height(imageModel.height)
            .width(imageModel.width)
    )
}

@Composable
fun AppText(appTextModel: TextModel) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .padding(top = 20.dp),
        text = appTextModel.text,
        fontWeight = appTextModel.textType.fontWeight,
        fontSize = appTextModel.textType.fontSize,
        textAlign = TextAlign.Center
    )
}

@Composable
fun AppAnimatedButton(modifier: Modifier, buttonModel: ButtonModel, visibility: Boolean) {
    CompactColumn(modifier.padding(horizontal = 40.dp)) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = visibility,
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut()
        ) {
            AppButton(buttonModel)
        }
    }
}

@Composable
fun GetAppBarLogoImage() {
    Image(
        modifier = Modifier.padding(horizontal = 20.dp),
        painter = painterResource(R.drawable.mainlogo),
        contentDescription = "Contact profile picture",
    )
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(pagerModel: PagerModel) {
    val scope = rememberCoroutineScope()
    var selectedTabIndex = pagerModel.pagerState.currentPage

    Row() {
        Spacer(modifier = Modifier.weight(3f))
        TabRow(
            modifier = Modifier.weight(2f),
            containerColor = Color.Transparent,
            indicator = { },
            divider = {},
            selectedTabIndex = selectedTabIndex
        ) {
            pagerModel.pagerList.forEachIndexed { index, model ->

                Tab(selected = selectedTabIndex == index, onClick = {
                    if (selectedTabIndex != index) {
                        scope.launch {
                            pagerModel.pagerState.animateScrollToPage(index)
                        }
                    }
                }) {
                    if (pagerModel.pagerList[selectedTabIndex].title == model.title) {
                        Text(
                            modifier = Modifier.padding(all = 10.dp),
                            text = model.title,
                            color = Color.White,
                            style = TextStyle(fontWeight = FontWeight.W600, fontSize = 20.sp)
                        )
                    } else {
                        Text(
                            modifier = Modifier.padding(all = 10.dp),
                            text = model.title,
                            color = Color.White
                        )
                    }

                }

            }
        }
    }

}

@Composable
fun FloatingBottomBar(
    modifier: Modifier,
    scrollState: MutableState<ScrollState>,
    iconsList: List<AppClickableIcons>
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = scrollState.value == ScrollState.SCROLL_UP,
        enter = slideInVertically(initialOffsetY = { 300 }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { 300 }) + fadeOut()
    ) {
        Card(
            modifier = modifier.padding(bottom = 20.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 20.dp),
            shape = RoundedCornerShape(70.dp),
            colors = CardDefaults.cardColors(containerColor = Purple40),
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 30.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                iconsList.forEach { AppSmallIconButton(it.icon, it.onClick) }
            }
        }
    }
}


@Composable
fun AppSmallIconButton(icon: ImageVector, onClick: () -> Unit) {
    IconButton(modifier = Modifier.width(60.dp), onClick = { onClick() }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(icon, contentDescription = "", modifier = Modifier.size(20.dp))
            Text(text = "End", style = TextStyle(fontSize = 12.sp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextViewWithEndIconComposable(textViewDataModel: TextViewModel) {
    textViewDataModel.stateText = remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
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
            ) {
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

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchTextView() {
    Column(Modifier.fillMaxWidth()) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        val animatedVisibility = false
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = textState.value,
            singleLine = true,
            onValueChange = { textState.value = it },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = darkColorScheme().surface,
                cursorColor = Color.White,
                textColor = Color.White,
                focusedIndicatorColor = Color.White
            ),
            trailingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    tint = Color.White
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            )
        )

        AnimatedVisibility(visible = textState.value.text.isNotEmpty()) {
           Column(Modifier.fillMaxWidth()) {
               List(10){
                   Text(
                       modifier = Modifier.padding(all = 10.dp),
                       text = "Suggestion",
                       style = TextStyle(color = Color.White),
                       fontSize = 18.sp,
                       fontWeight = FontWeight.W600
                   )
               }
           }
        }
    }
}


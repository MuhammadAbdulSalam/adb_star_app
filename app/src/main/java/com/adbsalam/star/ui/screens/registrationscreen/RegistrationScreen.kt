package com.adbsalam.star.ui.screens.registrationscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.adbsalam.star.ui.theme.Adb_salam_starTheme
import com.adbsalam.star.ui.theme.Adb_salam_starTheme_fullscreen
import com.adbsalam.star.ui.uiutil.FullScreenColumn
import com.adbsalam.star.ui.uiutil.LinearLayoutCompose
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel

@Composable
fun RegistrationScreen(navController: NavController? = null) {
    val nameState = TextViewModel("full name")
    val emailState = TextViewModel("email")
    val addressLine1State = TextViewModel("address line 1")
    val postcodeState = TextViewModel("postcode")
    val cityState = TextViewModel("city")
    val phoneNumberState = TextViewModel("phone number", textFormat = TextViewModel.TextFormat.NUMBERS_ONLY)
    val buttonSubmitModel = ButtonModel("Submit")


    FullScreenColumn(verticalArrangement = Arrangement.Center, composable = {
        LinearLayoutCompose(modelView = listOf(nameState, emailState, addressLine1State, postcodeState, cityState, phoneNumberState, buttonSubmitModel))
    })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Adb_salam_starTheme_fullscreen {
        RegistrationScreen()
    }
}
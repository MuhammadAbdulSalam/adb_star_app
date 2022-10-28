package com.adbsalam.star.ui.screens.homescreen.homefrags.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import com.adbsalam.star.ui.uiutil.LinearLayoutCompose
import com.adbsalam.star.ui.uiutil.NavigationFragmentColumn
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel

@Composable
fun MainHomeScreen() {
    val nameState = TextViewModel("full name")
    val emailState = TextViewModel("email")
    val addressLine1State = TextViewModel("address line 1")
    val postcodeState = TextViewModel("postcode")
    val cityState = TextViewModel("city")
    val phoneNumberState = TextViewModel("phone number", textFormat = TextViewModel.TextFormat.NUMBERS_ONLY)
    val buttonSubmitModel = ButtonModel("Submit")

    NavigationFragmentColumn(verticalArrangement = Arrangement.Top ){
        LinearLayoutCompose(modelView = listOf(nameState, emailState, addressLine1State, postcodeState, cityState, phoneNumberState, buttonSubmitModel))
    }
}


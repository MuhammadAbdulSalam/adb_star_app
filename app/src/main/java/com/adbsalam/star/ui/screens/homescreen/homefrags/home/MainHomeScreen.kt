package com.adbsalam.star.ui.screens.homescreen.homefrags.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adbsalam.star.ui.screens.homescreen.viewmodel.HomeScreenViewModel
import com.adbsalam.star.ui.uiutil.LinearLayoutCompose
import com.adbsalam.star.ui.uiutil.NavigationFragmentColumn
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun MainHomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {

    val nameState = TextViewModel("full name")
    val emailState = TextViewModel("email")
    val addressLine1State = TextViewModel("address line 1")
    val postcodeState = TextViewModel("postcode")
    val cityState = TextViewModel("city")
    val phoneNumberState = TextViewModel("phone number", textFormat = TextViewModel.TextFormat.NUMBERS_ONLY)
    val buttonSubmitModel = ButtonModel("Submit")

    val lifecycleOwner = LocalLifecycleOwner.current

    NavigationFragmentColumn(verticalArrangement = Arrangement.Top ){
        LinearLayoutCompose(modelView = listOf(nameState, emailState, addressLine1State, postcodeState, cityState, phoneNumberState, buttonSubmitModel))
    }


    lifecycleOwner.lifecycleScope.launchWhenCreated {
        viewModel.popularMovies.collect{
            if(it.isSuccess){


                Log.d("============", "--------------------------------------" + lifecycleOwner.lifecycle.currentState.name)
            }
        }
    }

}


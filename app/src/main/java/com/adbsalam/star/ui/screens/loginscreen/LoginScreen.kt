package com.adbsalam.star.ui.screens.loginscreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.adbsalam.star.R
import com.adbsalam.star.navigation.mainactivitynavigation.MainActivityNavigationRoutes
import com.adbsalam.star.ui.theme.Adb_salam_starTheme
import com.adbsalam.star.ui.uiutil.AppImageView
import com.adbsalam.star.ui.uiutil.FullScreenColumn
import com.adbsalam.star.ui.uiutil.LinearLayoutCompose
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.ImageModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel

@Composable
fun LoginScreenCompose(navController: NavController? = null) {
    val userNameState = TextViewModel("username", remember { mutableStateOf(TextFieldValue()) })
    val passwordState = TextViewModel("password", remember { mutableStateOf(TextFieldValue()) }, textFormat = TextViewModel.TextFormat.PASSWORD)

    val buttonModel = ButtonModel("Login", Alignment.TopEnd)
    val newAccountModel = ButtonModel("Create new account", Alignment.TopEnd, isTextButton = true)
    val forgottenPasswordModel = ButtonModel("Forgot Password?", Alignment.TopEnd, isTextButton = true)

    newAccountModel.onClickListener = { navController?.navigate(MainActivityNavigationRoutes.REGISTRATION_SCREEN.name) }

    FullScreenColumn(verticalArrangement = Arrangement.SpaceEvenly, composable = {
            AppImageView(imageModel = ImageModel(R.drawable.mainlogo, ""))
            LinearLayoutCompose(modelView = listOf(userNameState, passwordState, buttonModel))
            LinearLayoutCompose(modelView = listOf(newAccountModel, forgottenPasswordModel)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Adb_salam_starTheme {
        LoginScreenCompose()
    }
}
package com.adbsalam.star.ui.screens.loginscreen


import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.adbsalam.star.R
import com.adbsalam.star.navigation.mainactivitynavigation.MainActivityNavigationRoutes
import com.adbsalam.star.ui.screens.homescreen.homeactivity.MainHomeScreenActivity
import com.adbsalam.star.ui.theme.Adb_salam_starTheme
import com.adbsalam.star.ui.theme.Adb_salam_starTheme_fullscreen
import com.adbsalam.star.ui.uiutil.AppImageView
import com.adbsalam.star.ui.uiutil.FullScreenColumn
import com.adbsalam.star.ui.uiutil.LinearLayoutCompose
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.ImageModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel


private var userNameState = TextViewModel("username" )
private val passwordState = TextViewModel("password", textFormat = TextViewModel.TextFormat.PASSWORD)
private val btnLoginModel = ButtonModel("Login")
private val btnNewAccountModel = ButtonModel("Create New Account", isTextButton = true)
private val btnForgotPasswordModel = ButtonModel("Forgot Password?", isTextButton = true)
private val imageModel = ImageModel(R.drawable.mainlogo, "")


@Composable
fun LoginScreenCompose(navController: NavController? = null) {
    val context = LocalContext.current

    btnNewAccountModel.onClickListener = { navController?.navigate(MainActivityNavigationRoutes.REGISTRATION_SCREEN.name) }
    btnLoginModel.onClickListener = { context.startActivity(Intent(context, MainHomeScreenActivity::class.java)) }

    FullScreenColumn(verticalArrangement = Arrangement.SpaceEvenly) {
            AppImageView(imageModel = imageModel)
            LinearLayoutCompose(modelView = listOf(userNameState, passwordState, btnLoginModel))
            LinearLayoutCompose(modelView = listOf(btnNewAccountModel, btnForgotPasswordModel))
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Adb_salam_starTheme_fullscreen() {
        LoginScreenCompose()
    }
}
package com.adbsalam.star.ui.screens.registrationscreens.loginscreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.adbsalam.star.R
import com.adbsalam.star.ui.screens.homescreen.homeactivity.MainHomeScreenActivity
import com.adbsalam.star.ui.screens.registrationscreens.loginscreen.navgraph.LoginScreenRoutes
import com.adbsalam.star.ui.uiutil.AppImageView
import com.adbsalam.star.ui.uiutil.FullScreenColumn
import com.adbsalam.star.ui.uiutil.LinearLayoutCompose
import com.adbsalam.star.ui.uiutil.uidatamodels.ButtonModel
import com.adbsalam.star.ui.uiutil.uidatamodels.ImageModel
import com.adbsalam.star.ui.uiutil.uidatamodels.TextViewModel
import com.adbsalam.star.utility.launchActivity


private var userNameState = TextViewModel("username" )
private val passwordState = TextViewModel("password", textFormat = TextViewModel.TextFormat.PASSWORD)
private val btnLoginModel = ButtonModel("Login")
private val btnNewAccountModel = ButtonModel("Create New Account", isTextButton = true)
private val btnForgotPasswordModel = ButtonModel("Forgot Password?", isTextButton = true)
private val imageModel = ImageModel(R.drawable.mainlogo, "")


@Composable
fun LoginScreenCompose(navController: NavController? = null) {
    val context = LocalContext.current

    btnNewAccountModel.onClickListener = { navController?.navigate(LoginScreenRoutes.OnRegistration.route) }
    btnLoginModel.onClickListener = {
        context.launchActivity<MainHomeScreenActivity> {
            val activity = context as LoginActivity
            activity.finish()
        }
    }

    FullScreenColumn(verticalArrangement = Arrangement.SpaceEvenly) {
            AppImageView(imageModel = imageModel)
            LinearLayoutCompose(modelView = listOf(userNameState, passwordState, btnLoginModel))
            LinearLayoutCompose(modelView = listOf(btnNewAccountModel, btnForgotPasswordModel))
        }
}

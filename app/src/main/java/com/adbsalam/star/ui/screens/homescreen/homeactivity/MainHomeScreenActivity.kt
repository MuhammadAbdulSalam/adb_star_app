package com.adbsalam.star.ui.screens.homescreen.homeactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adbsalam.star.ui.theme.Adb_salam_starTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainHomeScreenActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Adb_salam_starTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeActivityScreen()
                }
            }
        }

    }
}

@Composable
fun HomeActivityScreen() {
    Text(text = "homescreen")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Adb_salam_starTheme {
        HomeActivityScreen()
    }
}
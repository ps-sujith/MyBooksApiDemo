package com.sujith.ui.feature_splash


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sujith.ui.R
import com.sujith.ui.navigation.BookList
import com.sujith.ui.navigation.Splash
import com.sujith.ui.resource.extra_large_font_size
import com.sujith.ui.utils.AppTitle
import com.sujith.ui.utils.Lottie
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Lottie(
            rawFile = R.raw.splash,
            isPlaying = true,
            iterations = Int.MAX_VALUE,
            modifier = Modifier.size(300.dp)
        )
        AppTitle(extra_large_font_size)
        LaunchedEffect(key1 = true) {
            delay(3000)
            navController.navigate(BookList) {
                popUpTo<Splash> {
                    inclusive = true
                }
            }
        }
    }
}

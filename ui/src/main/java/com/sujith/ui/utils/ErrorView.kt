package com.sujith.ui.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sujith.ui.R
import com.sujith.ui.resource.large_font_size
import com.sujith.ui.resource.loader_size_small

@Composable
fun ErrorView(error: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Lottie(
            rawFile = R.raw.error_anim,
            isPlaying = true,
            iterations = Int.MAX_VALUE,
            modifier = Modifier.size(loader_size_small)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = error,
            fontSize = large_font_size,
            color = MaterialTheme.colorScheme.onBackground,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        )
    }
}

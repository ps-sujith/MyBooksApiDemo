package com.sujith.ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import com.sujith.ui.resource.appName
import com.sujith.ui.resource.app_bar_title_size

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    scrollBehavior: TopAppBarScrollBehavior,
    addNavigateBack: Boolean,
    onNavigateBackClick: () -> Unit
) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        title = {
            AppTitle(app_bar_title_size)
        },

        navigationIcon = {
            if (addNavigateBack) {
                IconButton(onClick = { onNavigateBackClick() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "BACK"
                    )
                }
            }
        }
    )
}

@Composable
fun AppTitle(textSize: TextUnit) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = textSize,
                fontWeight = FontWeight.W300,
                fontStyle = FontStyle.Italic
            )
        ) {
            append("My ")
        }
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                fontSize = textSize,
            )
        ) {
            append(appName)
        }

    }
    Text(
        text = annotatedString,
        fontWeight = FontWeight.ExtraBold,
        color = MaterialTheme.colorScheme.onBackground
    )
}

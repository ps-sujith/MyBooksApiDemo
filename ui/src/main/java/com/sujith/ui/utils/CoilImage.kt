package com.sujith.ui.utils

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sujith.ui.R


@Composable
fun CoilImage(
    modifier: Modifier = Modifier,
    context: Context,
    imageUri: String?,
    placeholder: Int = R.drawable.placeholder
) {
    if (imageUri.isNullOrEmpty()) {
        Image(
            painter = painterResource(id = R.drawable.placeholder),
            contentDescription = "User image",
            contentScale = ContentScale.Inside,
            modifier = modifier
        )

    } else {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(imageUri)
                .crossfade(true)
                .placeholder(placeholder)
                .build(),
            contentDescription = "User image",
            error = painterResource(id = R.drawable.placeholder),
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}
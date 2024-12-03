package com.sujith.ui.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.sujith.ui.resource.card_view_card_elevation
import com.sujith.ui.resource.padding_large
import com.sujith.ui.resource.padding_medium
import com.sujith.ui.resource.small_medium_font_size


@Composable
fun TitleTextComponent(title: String, content: String) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(
                horizontal = padding_large,
                vertical = padding_medium
            ),
        elevation = CardDefaults.elevatedCardElevation(card_view_card_elevation),

        ) {


        Text(
            text = title,
            fontSize = small_medium_font_size,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 2,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(padding_medium)
        )

        Text(
            text = content,
            fontSize = small_medium_font_size,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 2,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(padding_medium)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TitleTextComponentPreview() {
    Surface {
        TitleTextComponent("Age", "description")
    }
}
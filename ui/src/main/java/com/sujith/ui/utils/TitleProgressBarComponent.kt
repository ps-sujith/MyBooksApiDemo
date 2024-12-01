package com.sujith.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sujith.ui.resource.card_view_card_elevation
import com.sujith.ui.resource.padding_large
import com.sujith.ui.resource.padding_small
import com.sujith.ui.resource.small_font_size


@Composable
fun TitleProgressBarComponent(title: String, incomingProgress: Int) {
    val configuration = LocalConfiguration.current
    Card(
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(
                horizontal = padding_large,
                vertical = padding_small
            ),
        elevation = CardDefaults.elevatedCardElevation(card_view_card_elevation),

        ) {
        Row(
            modifier = Modifier
                .padding(padding_large)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = title,
                fontSize = small_font_size,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2,
                fontFamily = FontFamily.Serif,
            )

            CustomLinearProgressIndicator(
                modifier = Modifier.width((configuration.screenWidthDp / 2).dp),
                progress = incomingProgress
            )

        }
    }
}

@Composable
fun CustomLinearProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Int,
    clipShape: RoundedCornerShape = RoundedCornerShape(10.dp)
) {
    Box(
        modifier = modifier
            .clip(clipShape)
            .background(Color.Gray)
            .height(8.dp)

    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color.Blue,
                            Color.Magenta
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(10f, 10f),
                        tileMode = TileMode.Mirror
                    )
                )
                .fillMaxHeight()
                .fillMaxWidth(progress / 10f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TitleProgressBarComponentPreview() {
    Surface {
        TitleProgressBarComponent("Age", 5)
    }
}
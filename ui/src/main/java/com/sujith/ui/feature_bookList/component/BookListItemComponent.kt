package com.sujith.ui.feature_bookList.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import com.sujith.domain.feature_bookList.model.BookItem
import com.sujith.ui.R
import com.sujith.ui.resource.card_view_card_elevation
import com.sujith.ui.resource.extra_small_font_size
import com.sujith.ui.resource.list_item_height
import com.sujith.ui.resource.medium_font_size
import com.sujith.ui.resource.padding_extra_small
import com.sujith.ui.resource.padding_medium
import com.sujith.ui.utils.CoilImage
import com.sujith.ui.utils.ItemUtil


@Composable
fun BookListItemComponent(
    book: BookItem,
    onItemClick: (id: String) -> Unit
) {
    val context = LocalContext.current
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(list_item_height)
        .clickable { onItemClick(book.id) }
        .padding(padding_medium),
        elevation = CardDefaults.elevatedCardElevation(card_view_card_elevation),
        colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        var size by remember { mutableStateOf(IntSize.Zero) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .onSizeChanged {
                    size = it
                },
            contentAlignment = Alignment.BottomStart,
        ) {
            CoilImage(
                context = context, imageUri = book.coverUrl, modifier = Modifier
                    .fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = (size.height / 3).toFloat(), endY = size.height.toFloat(),
                            tileMode = TileMode.Decal

                        )
                    )
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = book.title!!,
                    modifier = Modifier
                        .padding(start = padding_medium)
                        .fillMaxWidth(),
                    fontSize = medium_font_size,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(
                        Font(R.font.title_regular, FontWeight.Thin)
                    )
                )

                if (book.authorNames.isNotEmpty()) {
                    Text(
                        text = book.authorNames.joinToString(),
                        modifier = Modifier
                            .padding(
                                start = padding_medium,
                                bottom = padding_extra_small
                            )
                            .fillMaxWidth(),
                        fontSize = extra_small_font_size,
                        maxLines = 3,
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Monospace
                    )
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun CatListItemComponentPreview() {
    Surface {
        BookListItemComponent(
            book = ItemUtil.getDummyBookItem(),
            onItemClick = {})
    }
}
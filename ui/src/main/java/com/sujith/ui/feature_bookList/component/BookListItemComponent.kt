package com.sujith.ui.feature_bookList.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sujith.domain.feature_bookList.model.BookItem
import com.sujith.ui.R
import com.sujith.ui.resource.card_view_card_elevation
import com.sujith.ui.resource.card_view_card_elevation_image
import com.sujith.ui.resource.list_item_height
import com.sujith.ui.resource.medium_font_size
import com.sujith.ui.resource.padding_extra_small
import com.sujith.ui.resource.padding_large
import com.sujith.ui.resource.padding_medium
import com.sujith.ui.resource.small_font_size
import com.sujith.ui.utils.CoilImage
import com.sujith.ui.utils.ItemUtil


@Composable
fun BookListItemComponent(
    book: BookItem,
    onItemClick: (id: String) -> Unit
) {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current

    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize()
        .clickable { onItemClick(book.id) }
        .padding(padding_medium),
        elevation = CardDefaults.elevatedCardElevation(card_view_card_elevation),
        colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(list_item_height)
            ) {
                Card(
                    modifier = Modifier
                        .width((configuration.screenWidthDp / 2).dp)
                        .padding(padding_large)
                        .shadow(
                            elevation = card_view_card_elevation_image,
                            shape = RoundedCornerShape(8.dp),
                            spotColor = MaterialTheme.colorScheme.onBackground,
                            ambientColor = MaterialTheme.colorScheme.onBackground
                        )

                ) {
                    CoilImage(
                        context = context,
                        imageUri = book.coverUrl,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
        Text(
            text = book.title!!,
            modifier = Modifier
                .padding(horizontal = padding_medium)
                .fillMaxWidth(),
            fontSize = medium_font_size,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily(
                Font(R.font.helsinki, FontWeight.Thin)
            )
        )

        if (book.authorNames.isNotEmpty()) {
            Text(
                text = book.authorNames.joinToString(),
                modifier = Modifier
                    .padding(
                        horizontal = padding_medium,
                        vertical = padding_extra_small
                    )
                    .fillMaxWidth(),
                fontSize = small_font_size,
                maxLines = 3,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookListItemComponentPreview() {
    Surface {
        BookListItemComponent(
            book = ItemUtil.getDummyBookItem(),
            onItemClick = {})
    }
}
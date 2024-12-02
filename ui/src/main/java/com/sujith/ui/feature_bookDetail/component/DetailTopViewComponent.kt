//package com.sujith.ui.feature_bookDetail.component
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.CalendarMonth
//import androidx.compose.material.icons.sharp.Home
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.dimensionResource
//import androidx.compose.ui.res.vectorResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.sujith.domain.feature_bookList.model.BookItem
//import com.sujith.ui.R
//import com.sujith.ui.resource.card_view_card_elevation
//import com.sujith.ui.resource.extra_large_font_size
//import com.sujith.ui.resource.padding_extra_small
//import com.sujith.ui.resource.padding_large
//import com.sujith.ui.resource.padding_small
//import com.sujith.ui.utils.CoilImage
//import com.sujith.ui.utils.ItemUtil
//
//@Composable
//fun DetailsTopViewComponent(selectedBook:BookItem) {
//    val context = LocalContext.current
//    val configuration = LocalConfiguration.current
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Card(
//            modifier = Modifier
//                .height((configuration.screenHeightDp / 2.5).dp)
//                .fillMaxWidth()
//                .padding(
//                    horizontal = padding_large,
//                    vertical = padding_small
//                ),
//            elevation = CardDefaults.elevatedCardElevation(card_view_card_elevation),
//
//            ) {
//            CoilImage(
//                context = context,
//                imageUri = selectedBook.coverUrl,
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = padding_large),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Absolute.SpaceBetween
//        ) {
//            Text(
//                text = selectedBook.title?:"",
//                modifier = Modifier.padding(padding_extra_small),
//                fontSize = extra_large_font_size,
//                color = MaterialTheme.colorScheme.onBackground,
//                fontWeight = FontWeight.ExtraBold,
//                fontFamily = FontFamily(
//                    Font(R.font.title_regular, FontWeight.Light)
//                ),
//                style = TextStyle(
//                    brush = Brush.linearGradient(
//                        colors = listOf(
//                            Color.Blue,
//                            Color.Magenta,
//                            Color.Blue,
//                            Color.Cyan,
//                        )
//                    )
//                )
//            )
//
//        }
//        Spacer(modifier = Modifier.height(5.dp))
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(padding_large),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            if (catItem.originCountry.isNotEmpty()) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                ) {
//                    Icon(
//                        Icons.Filled.CalendarMonth,
//                        tint = MaterialTheme.colorScheme.onBackground,
//                        contentDescription = "Country of Origin"
//                    )
//                    Text(
//                        text = catItem.originCountry,
//                        fontSize = dimensionResource(id = R.dimen.small_font_size).value.sp,
//                        color = MaterialTheme.colorScheme.onBackground,
//                        fontFamily = FontFamily.Serif,
//
//                        )
//                }
//            }
//            if (catItem.lifeSpan.isNotEmpty()) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_small))
//                ) {
//                    Icon(
//                        Icons.Sharp.Home,
//                        tint = MaterialTheme.colorScheme.onBackground,
//                        contentDescription = "Country of Origin"
//                    )
//                    Text(
//                        text = catItem.lifeSpan,
//                        fontSize = dimensionResource(id = R.dimen.small_font_size).value.sp,
//                        color = MaterialTheme.colorScheme.onBackground,
//                        fontFamily = FontFamily.Serif,
//                    )
//                }
//            }
//
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DetailsTopViewComponentPreview() {
//    Surface {
//        DetailsTopViewComponent(selectedBook = ItemUtil.getDummyCatItem())
//    }
//}

//package com.sujith.ui.feature_bookDetail.component
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.dimensionResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.sp
//import com.sujith.catapidemo.ui.utils.ItemUtil
//import com.sujith.catapidemo.ui.utils.TitleProgressBarComponent
//import com.sujith.ui.R
//
//@Composable
//fun DetailsBottomViewComponent(bookDetailUiState: BookDetailUiState) {
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            modifier = Modifier.padding(dimensionResource(R.dimen.padding_large)),
//            text = catItem.description,
//            fontSize = dimensionResource(id = R.dimen.small_medium_font_size).value.sp,
//            color = MaterialTheme.colorScheme.onBackground,
//            fontFamily = FontFamily.Serif,
//        )
//        TitleProgressBarComponent(stringResource(R.string.adaptability_level), catItem.adaptabilityLevel)
//        TitleProgressBarComponent(stringResource(R.string.affection_level), catItem.affectionLevel)
//        TitleProgressBarComponent(stringResource(R.string.intelligence_level), catItem.intelligenceLevel)
//        TitleProgressBarComponent(stringResource(R.string.energy_level), catItem.energyLevel)
//        TitleProgressBarComponent(stringResource(R.string.child_friendly_level), catItem.childFriendlyLevel)
//        TitleProgressBarComponent(stringResource(R.string.dog_friendly_level), catItem.dogFriendlyLevel)
//        Spacer(Modifier.height(dimensionResource(R.dimen.padding_large)))
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DetailsBottomViewComponentPreview() {
//    Surface {
//        DetailsBottomViewComponent(bookDetailUiState = ItemUtil.getDummyCatItem())
//    }
//}

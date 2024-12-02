package com.sujith.ui.feature_bookDetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sujith.domain.feature_bookDetail.model.BookDetailItem
import com.sujith.ui.resource.detailTitle
import com.sujith.ui.resource.padding_large
import com.sujith.ui.resource.subjectPeopleTitle
import com.sujith.ui.resource.subjectPlacesTitle
import com.sujith.ui.resource.subjectsTitle
import com.sujith.ui.utils.ItemUtil
import com.sujith.ui.utils.TitleTextComponent


@Composable
fun DetailsBottomViewComponent(bookDetail: BookDetailItem) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(padding_large))

        bookDetail.detail?.let { desc ->
            if (desc is String) {
                TitleTextComponent(detailTitle, desc)
            }
        }
        if (bookDetail.subjects.isNotEmpty()) {
            TitleTextComponent(subjectsTitle, bookDetail.subjects.joinToString())
        }
        if (bookDetail.subjectPeople.isNotEmpty()) {
            TitleTextComponent(subjectPeopleTitle, bookDetail.subjectPeople.joinToString())
        }
        if (bookDetail.subjectPlaces.isNotEmpty()) {
            TitleTextComponent(subjectPlacesTitle, bookDetail.subjectPlaces.joinToString())
        }

        Spacer(Modifier.height(padding_large))
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsBottomViewComponentPreview() {
    Surface {
        DetailsBottomViewComponent(bookDetail = ItemUtil.getDummyBookDetailItem())
    }
}

package com.sujith.ui.feature_bookDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sujith.domain.feature_bookList.model.BookItem
import com.sujith.ui.feature_bookDetail.component.BookDetailUiState
import com.sujith.ui.feature_bookDetail.component.DetailsBottomViewComponent
import com.sujith.ui.feature_bookDetail.component.DetailsTopViewComponent
import com.sujith.ui.resource.padding_large


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(
    bookListUiState: BookItem?, bookDetailUiState: BookDetailUiState, onBackClick: () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        sheetState = modalBottomSheetState,
        onDismissRequest = { onBackClick() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .padding(10.dp)
        ) {
            bookListUiState?.let {
                DetailsTopViewComponent(selectedBook = bookListUiState)
            }
            if (bookDetailUiState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(padding_large),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                bookDetailUiState.bookDetail?.let {
                    DetailsBottomViewComponent(bookDetail = it)
                }
            }
        }
    }
}






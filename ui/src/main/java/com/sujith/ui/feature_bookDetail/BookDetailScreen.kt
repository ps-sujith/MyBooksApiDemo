package com.sujith.ui.feature_bookDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.SecureFlagPolicy
import com.sujith.domain.feature_bookList.model.BookItem
import com.sujith.ui.feature_bookDetail.component.BookDetailUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatDetailScreen(
    selectedBook: BookItem,
    bookDetail: BookDetailUiState, onBackClick: () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        sheetState = modalBottomSheetState,
        modifier = Modifier.background(Color.Transparent),
        properties = ModalBottomSheetProperties(
            shouldDismissOnBackPress = true,
            securePolicy = SecureFlagPolicy.SecureOff,
            isFocusable = false
        ),
        containerColor = Color.Transparent,
        tonalElevation = 10.dp,
        dragHandle = {
            BottomSheetDefaults.DragHandle(
                height = 0.dp,
                width = 0.dp,
                color = Color.Red
            )
        },
        onDismissRequest = { onBackClick() }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background)
                .padding(10.dp)
        ) {
            //  DetailsTopViewComponent(selectedBook = selectedBook)
//                DetailsBottomViewComponent(catItem = selectedItem)
        }
    }
}






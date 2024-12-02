package com.sujith.ui.feature_bookDetail.component

import com.sujith.domain.feature_bookDetail.model.BookDetailItem

data class BookDetailUiState(
    val isLoading: Boolean = false,
    val bookDetail: BookDetailItem? = null,
    val error: String = ""
)
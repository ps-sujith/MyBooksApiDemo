package com.sujith.ui.feature_bookList.component

import com.sujith.domain.feature_bookList.model.BookItem

data class BookListUiState(
    val isLoading: Boolean = false,
    val bookList: List<BookItem> = emptyList(),
    val error: String = ""
)
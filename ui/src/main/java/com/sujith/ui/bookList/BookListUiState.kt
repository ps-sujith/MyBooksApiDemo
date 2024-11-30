package com.sujith.ui.bookList

import com.sujith.domain.bookList.model.BookItem

data class BookListUiState(
    val isLoading: Boolean = false,
    val bookList: List<BookItem> = emptyList(),
    val error: String = ""
)
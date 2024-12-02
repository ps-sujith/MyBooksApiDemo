package com.sujith.ui.utils

import com.sujith.domain.feature_bookList.model.BookItem

object ItemUtil {
    fun getDummyCatItem() = BookItem(
        id = "/works/OL1983087W",
        title = "Biology",
        firstPublishYear = 1987,
        coverUrl = "https://covers.openlibrary.org/b/id/581911-M.jpg",
        authorNames = listOf("Neil Alexander Campbell")
    )
}
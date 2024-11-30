package com.sujith.data.characterList.mapper

import com.sujith.data.bookList.dto.Work
import com.sujith.domain.bookList.model.BookItem

fun Work.toDomain() = BookItem(
    id = key,
    title = title ?: "",
    firstPublishYear = firstPublishYear,
    coverUrl = "https://covers.openlibrary.org/b/id/${coverId}-M.jpg",
    authorNames = authorNames.toString(),
)


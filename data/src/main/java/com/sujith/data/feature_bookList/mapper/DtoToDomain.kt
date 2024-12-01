package com.sujith.data.characterList.mapper

import com.sujith.data.feature_bookList.dto.Work
import com.sujith.domain.feature_bookList.model.BookItem

fun Work.toDomain() = BookItem(
    id = key,
    title = title ?: "",
    firstPublishYear = firstPublishYear,
    coverUrl = "https://covers.openlibrary.org/b/id/${coverId}-M.jpg",
    authorNames = authorNames.toString(),
)


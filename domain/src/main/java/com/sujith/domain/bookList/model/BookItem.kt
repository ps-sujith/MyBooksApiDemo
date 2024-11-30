package com.sujith.domain.bookList.model

data class BookItem(
    val id: String,
    val title: String?,
    val firstPublishYear: Int,
    val coverUrl: String,
    val authorNames: String?,
)
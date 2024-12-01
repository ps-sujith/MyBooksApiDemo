package com.sujith.domain.feature_bookList.model

data class BookItem(
    val id: String,
    val title: String?,
    val firstPublishYear: Int,
    val coverUrl: String,
    val authorNames: String?,
)
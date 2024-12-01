package com.sujith.domain.feature_bookDetail.model

data class BookDetailItem(
    val detail: String,
    val subjectPeople: List<String>,
    val subjectPlaces: List<String>,
    val subjects: List<String>
)
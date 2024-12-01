package com.sujith.data.feature_bookDetail.mapper

import com.sujith.data.feature_bookDetail.dto.BookDetailDto
import com.sujith.domain.feature_bookDetail.model.BookDetailItem

fun BookDetailDto.toDomain() = BookDetailItem(
    detail = if (description.isNullOrEmpty()) "" else description,
    subjectPeople = if (subjectPeople.isNullOrEmpty()) emptyList() else subjectPeople,
    subjectPlaces = if (subjectPlaces.isNullOrEmpty()) emptyList() else subjectPlaces,
    subjects = if (subjects.isNullOrEmpty()) emptyList() else subjects
)


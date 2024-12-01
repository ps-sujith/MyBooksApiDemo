package com.sujith.domain.feature_bookDetail.repository

import com.sujith.domain.feature_bookDetail.model.BookDetailItem
import io.reactivex.Single

interface BookDetailRepository {
    fun getBookDetail(bookId: String): Single<BookDetailItem>
}
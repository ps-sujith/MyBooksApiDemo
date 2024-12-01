package com.sujith.data.feature_bookDetail.dataSource

import com.sujith.data.feature_bookDetail.dto.BookDetailDto
import io.reactivex.Single


interface RemoteBookDetailDataSource {
    fun getBookDetail(bookId: String): Single<BookDetailDto>
}
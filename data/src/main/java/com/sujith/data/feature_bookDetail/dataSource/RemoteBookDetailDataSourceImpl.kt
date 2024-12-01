package com.sujith.data.feature_bookDetail.dataSource

import com.sujith.data.common.api.BooksApiService
import com.sujith.data.feature_bookDetail.dto.BookDetailDto
import io.reactivex.Single
import javax.inject.Inject

class RemoteBookDetailDataSourceImpl @Inject constructor(private val apiService: BooksApiService) :
    RemoteBookDetailDataSource {
    override fun getBookDetail(bookId: String): Single<BookDetailDto> {
        return apiService.getBookDetail(bookId)
    }
}

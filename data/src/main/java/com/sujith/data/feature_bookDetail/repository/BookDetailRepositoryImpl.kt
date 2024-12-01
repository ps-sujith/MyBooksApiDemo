package com.sujith.data.feature_bookDetail.repository

import com.sujith.data.feature_bookDetail.dataSource.RemoteBookDetailDataSource
import com.sujith.data.feature_bookDetail.mapper.toDomain
import com.sujith.domain.feature_bookDetail.model.BookDetailItem
import com.sujith.domain.feature_bookDetail.repository.BookDetailRepository
import io.reactivex.Single
import javax.inject.Inject

class BookDetailRepositoryImpl @Inject constructor(private val remoteBookDetailDataSource: RemoteBookDetailDataSource) :
    BookDetailRepository {
    override fun getBookDetail(bookId: String): Single<BookDetailItem> {
        return remoteBookDetailDataSource.getBookDetail(bookId).map { it.toDomain() }
    }
}
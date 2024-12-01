package com.sujith.domain.feature_bookDetail.usecase

import com.sujith.domain.feature_bookDetail.model.BookDetailItem
import com.sujith.domain.feature_bookDetail.repository.BookDetailRepository
import io.reactivex.Single
import javax.inject.Inject


class GetBookDetailUseCase @Inject constructor(private val bookDetailRepository: BookDetailRepository) {
    fun getBookDetail(bookId: String): Single<BookDetailItem> {
        return bookDetailRepository.getBookDetail(bookId)
    }
}
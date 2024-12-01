package com.sujith.domain.feature_bookList.usecase

import com.sujith.domain.feature_bookList.model.BookItem
import com.sujith.domain.feature_bookList.repository.BookListRepository
import io.reactivex.Single
import javax.inject.Inject


class GetBookListUseCase @Inject constructor(private val bookListRepository: BookListRepository) {
    fun getAllBookList(): Single<List<BookItem>> {
        return bookListRepository.getReadBookList()
    }
}
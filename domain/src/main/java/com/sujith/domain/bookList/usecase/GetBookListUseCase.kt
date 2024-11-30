package com.sujith.domain.bookList.usecase

import com.sujith.domain.bookList.model.BookItem
import com.sujith.domain.bookList.repository.BookListRepository
import io.reactivex.Single
import javax.inject.Inject


class GetBookListUseCase @Inject constructor(private val bookListRepository: BookListRepository) {
    fun getAllBookList(): Single<List<BookItem>> {
        return bookListRepository.getReadBookList()
    }
}
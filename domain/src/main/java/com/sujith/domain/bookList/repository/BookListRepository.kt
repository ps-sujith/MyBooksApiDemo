package com.sujith.domain.bookList.repository

import com.sujith.domain.bookList.model.BookItem
import io.reactivex.Single

interface BookListRepository {
    fun getReadBookList(): Single<List<BookItem>>
}
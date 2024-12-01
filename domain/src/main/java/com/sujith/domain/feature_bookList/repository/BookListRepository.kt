package com.sujith.domain.feature_bookList.repository

import com.sujith.domain.feature_bookList.model.BookItem
import io.reactivex.Single

interface BookListRepository {
    fun getReadBookList(): Single<List<BookItem>>
}
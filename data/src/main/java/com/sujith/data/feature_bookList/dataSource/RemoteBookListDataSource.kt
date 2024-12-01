package com.sujith.data.feature_bookList.dataSource

import com.sujith.data.feature_bookList.dto.BookListDto
import io.reactivex.Single


interface RemoteBookListDataSource {
    fun getReadBookList(): Single<BookListDto>
}
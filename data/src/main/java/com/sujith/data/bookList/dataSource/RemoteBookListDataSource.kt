package com.sujith.data.bookList.dataSource

import com.sujith.data.bookList.dto.BookListDto
import io.reactivex.Single


interface RemoteBookListDataSource {
    fun getReadBookList(): Single<BookListDto>
}
package com.sujith.data.bookList.dataSource

import com.sujith.data.bookList.dto.BookListDto
import com.sujith.data.common.api.BooksApiService
import io.reactivex.Single
import javax.inject.Inject

class RemoteBookListDataSourceImpl @Inject constructor(private val apiService: BooksApiService) :
    RemoteBookListDataSource {
    override fun getReadBookList(): Single<BookListDto> {
        return apiService.getReadBookList()
    }

}

package com.sujith.data.feature_bookList.dataSource

import com.sujith.data.common.api.BooksApiService
import com.sujith.data.feature_bookList.dto.BookListDto
import io.reactivex.Single
import javax.inject.Inject

class RemoteBookListDataSourceImpl @Inject constructor(private val apiService: BooksApiService) :
    RemoteBookListDataSource {
    override fun getReadBookList(): Single<BookListDto> {
        return apiService.getReadBookList()
    }

}

package com.sujith.data.bookList.repository

import com.sujith.data.bookList.dataSource.RemoteBookListDataSource
import com.sujith.data.characterList.mapper.toDomain
import com.sujith.domain.bookList.model.BookItem
import com.sujith.domain.bookList.repository.BookListRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class BookListRepositoryImpl @Inject constructor(private val remoteBookListDataSource: RemoteBookListDataSource) :
    BookListRepository {
    override fun getReadBookList(): Single<List<BookItem>> {
        return remoteBookListDataSource.getReadBookList()
            .flatMap {
                Observable.fromIterable(it.readingLogEntries).map { entry -> entry.work.toDomain() }
                    .toList()
            }
    }
}
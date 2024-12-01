package com.sujith.data.common.api

import com.sujith.data.feature_bookDetail.dto.BookDetailDto
import com.sujith.data.feature_bookList.dto.BookListDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApiService {
    @GET("people/mekBot/books/already-read.json")
    fun getReadBookList(): Single<BookListDto>

    @GET("{bookId}.json")
    fun getBookDetail(@Path("bookId") id: String): Single<BookDetailDto>
}
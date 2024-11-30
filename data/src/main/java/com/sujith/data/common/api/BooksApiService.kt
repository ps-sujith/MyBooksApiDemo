package com.sujith.data.common.api

import com.sujith.data.bookList.dto.BookListDto
import io.reactivex.Single
import retrofit2.http.GET

interface BooksApiService {
    @GET("people/mekBot/books/alreccady-read.json")
    fun getReadBookList(): Single<BookListDto>
    fun getCatListWithBreed()
}
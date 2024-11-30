package com.sujith.data


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sujith.data.bookList.dataSource.RemoteBookListDataSource
import com.sujith.data.bookList.dataSource.RemoteBookListDataSourceImpl
import com.sujith.data.bookList.dto.BookListDto
import com.sujith.data.bookList.dto.ReadingLogEntry
import com.sujith.data.bookList.dto.Work
import com.sujith.data.common.api.BooksApiService
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever

class RemoteBookListDataSourceShould {
    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rxSchedulerRule = RxSchedulerRule()

    private lateinit var remoteDataSource: RemoteBookListDataSource
    private var booksApiService: BooksApiService = mock()
    private val expectedSuccess =
        BookListDto(
            listOf(
                ReadingLogEntry(
                    Work(
                        authorNames = listOf("Neil Alexander Campbell"),
                        coverId = 581911,
                        firstPublishYear = 1967,
                        key = "works/OL1983087W",
                        title = "Biology"
                    )
                )
            )
        )

    @Test
    fun `fetch all the book list from api service`() {
        mockSuccessfulCase()
        booksApiService.getReadBookList()
        verify(booksApiService, times(1)).getReadBookList()
    }

    @Test
    fun `return book list when when api is success`() {
        mockSuccessfulCase()
        val result = booksApiService.getReadBookList().test()
        assertEquals(1, result.values().size)
    }

    @Test
    fun `return null  when api fails `() {
        mockFailureCase()
        assertEquals(null, booksApiService.getReadBookList())
    }

    private fun mockSuccessfulCase() {
        whenever(booksApiService.getReadBookList()).thenReturn(Single.just(expectedSuccess))
        remoteDataSource = RemoteBookListDataSourceImpl(booksApiService)
    }

    private fun mockFailureCase() {
        whenever(booksApiService.getReadBookList()).thenReturn(null)
        remoteDataSource = RemoteBookListDataSourceImpl(booksApiService)
    }
}
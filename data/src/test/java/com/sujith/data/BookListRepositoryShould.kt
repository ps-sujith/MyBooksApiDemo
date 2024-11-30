package com.sujith.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sujith.data.bookList.dataSource.RemoteBookListDataSource
import com.sujith.data.bookList.dto.BookListDto
import com.sujith.data.bookList.dto.ReadingLogEntry
import com.sujith.data.bookList.dto.Work
import com.sujith.data.bookList.repository.BookListRepositoryImpl
import com.sujith.domain.bookList.model.BookItem
import com.sujith.domain.bookList.repository.BookListRepository
import io.reactivex.Single
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class BookListRepositoryShould {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rxSchedulerRule = RxSchedulerRule()

    private lateinit var bookListRepository: BookListRepository
    private val bookListDataSource: RemoteBookListDataSource = mock()


    @Test
    fun ` remote datasource  should at least invoked once when repository invoked`() {
        mockRemoteSuccessfulCase()
        bookListDataSource.getReadBookList()
        verify(bookListDataSource, times(1)).getReadBookList()
    }

    @Test
    fun `emit  success result with non empty list  when  received from  remote data source`() {
        mockRemoteSuccessfulCase()
        val result = bookListDataSource.getReadBookList().test()
        assertEquals(1, result.values().size)
    }

    @Test
    fun `emit null result  when empty result received from  remote data source`() = runTest {
        mockFailureCase()
        assertEquals(null, bookListDataSource.getReadBookList())
    }


    private fun mockRemoteSuccessfulCase() {
        val dummyList =
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

        whenever(bookListDataSource.getReadBookList()).thenReturn(Single.just(dummyList))
        bookListRepository = BookListRepositoryImpl(bookListDataSource)
    }

    private fun mockFailureCase() {
        whenever(bookListDataSource.getReadBookList()).thenReturn(null)
        bookListRepository = BookListRepositoryImpl(bookListDataSource)
    }
}
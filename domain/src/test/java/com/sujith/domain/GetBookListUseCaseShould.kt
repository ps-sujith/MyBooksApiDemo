package com.sujith.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sujith.domain.feature_bookList.model.BookItem
import com.sujith.domain.feature_bookList.repository.BookListRepository
import com.sujith.domain.feature_bookList.usecase.GetBookListUseCase
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GetBookListUseCaseShould {
    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rxSchedulerRule = RxSchedulerRule()

    private lateinit var getBookListUseCase: GetBookListUseCase
    private val bookListRepository: BookListRepository = mock()
    private val exceptedResult = BookItem(
        id = "/works/OL1983087W",
        title = "Biology",
        firstPublishYear = 1987,
        coverUrl = "https://covers.openlibrary.org/b/id/581911-M.jpg",
        authorNames = "Neil Alexander Campbell"
    )

    @Test
    fun `repository  should at least invoked once when use case invoked `() {
        mockSuccessfulCase()
        getBookListUseCase.getAllBookList()
        verify(bookListRepository, times(1)).getReadBookList()

    }

    @Test
    fun `emit  book list  when success received from repository`() {
        mockSuccessfulCase()
        val result = getBookListUseCase.getAllBookList().test()
        assertEquals(listOf(exceptedResult), result.values()[0])

    }

    @Test
    fun `emit empty list when error received from repository`() {
        mockFailureCase()
        val result = getBookListUseCase.getAllBookList().test()
        assertEquals(emptyList<BookItem>(), result.values()[0])
    }

    private fun mockSuccessfulCase() {
        whenever(bookListRepository.getReadBookList()).thenReturn(
            Single.just(listOf(exceptedResult))
        )
        getBookListUseCase = GetBookListUseCase(bookListRepository)
    }

    private fun mockFailureCase() {
        whenever(bookListRepository.getReadBookList()).thenReturn(
            Single.just(emptyList())
        )
        getBookListUseCase = GetBookListUseCase(bookListRepository)
    }
}
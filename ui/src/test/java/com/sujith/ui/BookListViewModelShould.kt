package com.sujith.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.sujith.domain.bookList.model.BookItem
import com.sujith.domain.bookList.usecase.GetBookListUseCase
import io.reactivex.Single
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever


class BookListViewModelShould {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val rxSchedulerRule = RxSchedulerRule()

    private lateinit var viewModel: BookListViewModel
    private val getBookListUseCase: GetBookListUseCase = mock()
    private val exceptedResult = BookItem(
        id = "/works/OL1983087W",
        title = "Biology",
        firstPublishYear = 1987,
        coverUrl = "https://covers.openlibrary.org/b/id/581911-M.jpg",
        authorNames = "Neil Alexander Campbell"
    )

    @Test
    fun `use case should at least invoked once when viewmodel launched`() {
        mockSuccessfulCase()
        verify(getBookListUseCase, times(1)).getAllBookList()
    }

    @Test
    fun `emit  state with book list  when success received from use case`() = runTest {
        mockSuccessfulCase()
        viewModel.bookListUiState.test {
            assertEquals(exceptedResult, awaitItem().bookList[0])
            cancelAndIgnoreRemainingEvents()
        }
    }

//    @Test
//    fun `emit Loading state when viewmodel launched `() = runTest {
//        mockSuccessfulCase()
//        assertEquals(true, viewModel.bookListUiState.value.isLoading)
//    }


    @Test
    fun `emit state with empty list  when error received from use case`() = runTest {
        mockFailureCase()
        viewModel.bookListUiState.test {
            assertEquals(emptyList<BookItem>(), awaitItem().bookList)
            cancelAndIgnoreRemainingEvents()
        }
    }

    private fun mockSuccessfulCase() {
        whenever(getBookListUseCase.getAllBookList()).thenReturn(
            Single.just(listOf(exceptedResult))
        )
        viewModel = BookListViewModel(getBookListUseCase)
    }

    private fun mockFailureCase() {
        whenever(getBookListUseCase.getAllBookList()).thenReturn(
            Single.just(emptyList())
        )
        viewModel = BookListViewModel(getBookListUseCase)
    }
}
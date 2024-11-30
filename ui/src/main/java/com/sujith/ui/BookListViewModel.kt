package com.sujith.ui

import androidx.compose.ui.util.trace
import androidx.lifecycle.ViewModel
import com.sujith.domain.bookList.usecase.GetBookListUseCase
import com.sujith.ui.bookList.BookListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(private val getBooksListUseCase: GetBookListUseCase) :
    ViewModel() {
    private val _bookListUiState = MutableStateFlow(BookListUiState(isLoading = true))
    val bookListUiState = _bookListUiState.asStateFlow()
    private val disposable: CompositeDisposable = CompositeDisposable()

    init {
        println("MATRIX _ VM INIT")
        loadBookList()
    }

    private fun loadBookList() {
        disposable.add(
            getBooksListUseCase.getAllBookList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    _bookListUiState.update { state ->
                        state.copy(
                            isLoading = true,
                        )
                    }
                }
                .subscribeBy(onSuccess = {
                    _bookListUiState.update { state ->
                        state.copy(
                            isLoading = false,
                            bookList = it
                        )
                    }
                }, onError = {
                    _bookListUiState.update { state ->
                        state.copy(
                            isLoading = false,
                            error = it.toString()
                        )
                    }
                })
        )
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
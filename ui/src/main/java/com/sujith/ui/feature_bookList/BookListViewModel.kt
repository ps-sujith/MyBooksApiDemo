package com.sujith.ui.feature_bookList

import androidx.lifecycle.ViewModel
import com.sujith.domain.feature_bookList.usecase.GetBookListUseCase
import com.sujith.ui.feature_bookList.component.BookListUiState
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
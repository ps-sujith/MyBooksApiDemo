package com.sujith.ui.feature_bookDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sujith.domain.feature_bookDetail.usecase.GetBookDetailUseCase
import com.sujith.ui.feature_bookDetail.component.BookDetailUiState
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
class BookDetailViewModel @Inject constructor(
    private val getBookDetailUseCase: GetBookDetailUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _bookDetailUiState = MutableStateFlow(BookDetailUiState(isLoading = false))
    val bookDetailUiState = _bookDetailUiState.asStateFlow()
    private val disposable: CompositeDisposable = CompositeDisposable()
    private val bookId: String = savedStateHandle.get<String>("bookId") ?: ""

    init {
        loadBookDetail(bookId)
    }

    private fun loadBookDetail(bookId: String) {
        disposable.add(
            getBookDetailUseCase.getBookDetail(bookId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    _bookDetailUiState.update { state ->
                        state.copy(
                            isLoading = true,
                        )
                    }
                }
                .subscribeBy(onSuccess = {
                    _bookDetailUiState.update { state ->
                        state.copy(
                            isLoading = false,
                            bookDetail = it
                        )
                    }
                }, onError = {
                    _bookDetailUiState.update { state ->
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
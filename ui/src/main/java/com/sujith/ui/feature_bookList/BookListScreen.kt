package com.sujith.ui.feature_bookList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.sujith.ui.R
import com.sujith.ui.feature_bookList.component.BookListItemComponent
import com.sujith.ui.feature_bookList.component.BookListUiState
import com.sujith.ui.utils.ErrorView
import com.sujith.ui.utils.Lottie
import com.sujith.ui.utils.TopAppBarComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(bookListUiState: BookListUiState, itemClick: (id: String) -> Unit) {
    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehaviour.nestedScrollConnection)
            .systemBarsPadding(),
        topBar = {
            TopAppBarComponent(scrollBehaviour, false) {}
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.surfaceContainer),
            contentAlignment = Alignment.Center
        ) {
            if (bookListUiState.isLoading) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surfaceContainer
                ) {
                    Lottie(
                        rawFile = R.raw.loader,
                        isPlaying = true,
                        iterations = Int.MAX_VALUE,
                        modifier = Modifier.padding(50.dp)
                    )
                }
            } else {
                if (bookListUiState.bookList.isNotEmpty()) {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.surfaceContainer),
                        columns = GridCells.Fixed(2),
                        content = {
                            items(bookListUiState.bookList) { bookItem ->
                                if (!bookItem.title.isNullOrEmpty()) {
                                    BookListItemComponent(bookItem) {
                                        itemClick(it)
                                    }
                                }
                            }
                        }
                    )
                } else {
                    ErrorView(error = "Something Went wrong !!")
                }
            }
        }
    }
}
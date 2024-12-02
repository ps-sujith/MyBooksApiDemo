package com.sujith.mybooksapidemo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sujith.ui.feature_bookDetail.BookDetailScreen
import com.sujith.ui.feature_bookDetail.BookDetailViewModel
import com.sujith.ui.feature_bookList.BookListScreen
import com.sujith.ui.feature_bookList.BookListViewModel
import com.sujith.ui.feature_splash.SplashScreen
import com.sujith.ui.navigation.BookDetail
import com.sujith.ui.navigation.BookList
import com.sujith.ui.navigation.MyBooksApp
import com.sujith.ui.navigation.Splash

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MyBooksApp) {
        navigation<MyBooksApp>(startDestination = Splash) {
            composable<Splash> {
                SplashScreen(navController)
            }
            composable<BookList> { entry ->
                val bookListVM =
                    entry.sharedViewModel<BookListViewModel>(navController = navController)
                val bookListUiState by bookListVM.bookListUiState.collectAsStateWithLifecycle()
                BookListScreen(bookListUiState) { bookId ->
                    navController.navigate(BookDetail(bookId))
                }
            }

            composable<BookDetail> { entry ->
                val bookListVM =
                    entry.sharedViewModel<BookListViewModel>(navController = navController)
                val bookListUiState by bookListVM.bookListUiState.collectAsStateWithLifecycle()
                val bookDetailVM: BookDetailViewModel = hiltViewModel(entry)
                val bookDetailUiState by bookDetailVM.bookDetailUiState.collectAsStateWithLifecycle()
                val bookId = entry.toRoute<BookDetail>().bookId
                val selectedBook =
                    bookListUiState.bookList.takeIf { it.isNotEmpty() }?.find { it.id == bookId }
                BookDetailScreen(
                    bookListUiState = selectedBook,
                    bookDetailUiState = bookDetailUiState
                ) {
                    navController.navigateUp()
                }
            }
        }
    }
}


///**
// * Inline function retrieve the existing viewmodel instance,if null returns a new instance
// * This enables to use the viemodel as a shared viewmodel since NavBackStackEntry is acting as
// * a viewmodelStoreOwner
// */
@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController,
): T {
    val navGraphRoute = destination.parent?.route ?: return hiltViewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return hiltViewModel(parentEntry)
}

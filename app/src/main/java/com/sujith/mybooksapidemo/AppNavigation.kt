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
import com.sujith.ui.feature_bookList.BookListScreen
import com.sujith.ui.feature_bookList.BookListViewModel
import com.sujith.ui.feature_splash.SplashScreen
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
                BookListScreen(bookListUiState) {

                }
            }
        }
//            composable<CatDetail> { entry ->
//                val catListViewModel =
//                    entry.sharedViewModel<CatListViewModel>(navController = navController)
//                val favouriteViewModel: FavouriteViewModel = koinViewModel()
//                val catListUiState by catListViewModel.catListUiState.collectAsStateWithLifecycle()
//                val favListUiState by favouriteViewModel.favListUiState.collectAsStateWithLifecycle()
//                //maintaining a single detail screen for cat list and favourite list
//                val isFromFavourites = entry.toRoute<CatDetail>().isInvokedFromFavourite
//                val sourceList =
//                    if (isFromFavourites) favListUiState.favList else catListUiState.catList
//                val catId = entry.toRoute<CatDetail>().id
//                val selectedCatItem =
//                    sourceList.takeIf { it.isNotEmpty() }?.firstOrNull { it.id == catId }
//                CatDetailScreen(
//                    navController = navController, selectedItem = selectedCatItem
//                ) { isFavourite, catListItem ->
//                    if (isFavourite) {
//                        favouriteViewModel.addFavouriteCat(catListItem.copy(isFavourite = true))
//                    } else {
//                        if (isFromFavourites) {
//                            navController.navigateUp()
//                        }
//                        favouriteViewModel.removeFavouriteCat(catListItem)
//                    }
//                }
//            }
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
    return hiltViewModel(viewModelStoreOwner = parentEntry)
}
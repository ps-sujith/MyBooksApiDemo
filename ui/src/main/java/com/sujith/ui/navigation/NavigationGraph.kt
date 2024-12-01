package com.sujith.ui.navigation

import kotlinx.serialization.Serializable

//Graphs
@Serializable
object MyBooksApp

//Screen
@Serializable
object Splash

@Serializable
object BookList

@Serializable
data class BookDetail(val bookId: String)



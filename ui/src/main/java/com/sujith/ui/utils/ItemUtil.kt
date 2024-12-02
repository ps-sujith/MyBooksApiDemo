package com.sujith.ui.utils

import com.sujith.domain.feature_bookDetail.model.BookDetailItem
import com.sujith.domain.feature_bookList.model.BookItem

object ItemUtil {
    fun getDummyBookItem() = BookItem(
        id = "/works/OL1983087W",
        title = "Biology",
        firstPublishYear = 1987,
        coverUrl = "https://covers.openlibrary.org/b/id/581911-M.jpg",
        authorNames = listOf("Neil Alexander Campbell")
    )

    fun getDummyBookDetailItem() = BookDetailItem(
        detail = "The main character of Fantastic Mr. Fox is an extremely clever anthropomorphized fox named Mr. Fox. He lives with his wife and four little foxes. In order to feed his family, he steals food from the cruel, brutish farmers named Boggis, Bunce, and Bean every night.\\r\\n\\r\\nFinally tired of being constantly outwitted by Mr. Fox, the farmers attempt to capture and kill him. The foxes escape in time by burrowing deep into the ground",
        subjectPeople = listOf(
            "Animals",
            "Hunger",
            "Open Library Staff Picks",
            "Juvenile fiction",
            "Children's stories, English"
        ),
        subjectPlaces = listOf(
            "Animals",
            "Hunger",
            "Open Library Staff Picks",
            "Juvenile fiction",
            "Children's stories, English"
        ),
        subjects = listOf(
            "Animals",
            "Hunger",
            "Open Library Staff Picks",
            "Juvenile fiction",
            "Children's stories, English"
        )
    )
}
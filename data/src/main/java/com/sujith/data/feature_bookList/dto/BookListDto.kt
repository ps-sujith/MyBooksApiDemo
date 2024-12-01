package com.sujith.data.feature_bookList.dto


import com.google.gson.annotations.SerializedName

data class BookListDto(
    @SerializedName("reading_log_entries")
    val readingLogEntries: List<ReadingLogEntry>
)

data class ReadingLogEntry(
    @SerializedName("work")
    val work: Work
)

data class Work(
    @SerializedName("author_names")
    val authorNames: List<String>,
    @SerializedName("cover_id")
    val coverId: Int,
    @SerializedName("first_publish_year")
    val firstPublishYear: Int,
    @SerializedName("key")
    val key: String,
    @SerializedName("title")
    val title: String
)
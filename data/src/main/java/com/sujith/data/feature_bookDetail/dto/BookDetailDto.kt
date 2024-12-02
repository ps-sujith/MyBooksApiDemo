package com.sujith.data.feature_bookDetail.dto


import com.google.gson.annotations.SerializedName

data class BookDetailDto(
    @SerializedName("description")
    val description: Any?,
    @SerializedName("subject_people")
    val subjectPeople: List<String>?,
    @SerializedName("subject_places")
    val subjectPlaces: List<String>?,
    @SerializedName("subjects")
    val subjects: List<String>?,
)
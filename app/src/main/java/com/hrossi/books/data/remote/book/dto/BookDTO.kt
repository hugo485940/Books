package com.hrossi.books.data.remote.book.dto

import com.google.gson.annotations.SerializedName

data class BookDTO(

    @SerializedName("title")
    val title: String?,

    @SerializedName("author")
    val author: String?,

    @SerializedName("imageURL")
    val imageURL: String?

)
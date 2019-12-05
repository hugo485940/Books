package com.hrossi.books.data.remote

import com.hrossi.books.data.remote.book.dto.BookDTO
import retrofit2.http.GET


interface BooksService {

    @GET("books.json")
    suspend  fun getBooks(): List<BookDTO>

}
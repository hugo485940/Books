package com.hrossi.books.data.remote.book

import com.hrossi.books.data.remote.book.dto.Book

interface BooksRepository {

    suspend fun getBooks(): List<Book>

}
package com.hrossi.books.data.remote.book

import com.hrossi.books.data.remote.BooksService
import com.hrossi.books.data.remote.book.dto.Book
import com.hrossi.books.data.remote.book.mapper.BookMapper

class BooksRepositoryImpl(
    private val service: BooksService,
    private val mapper: BookMapper
) : BooksRepository {

    override suspend fun getBooks(): List<Book> {
        return service.getBooks().map {
            mapper.fromDTO(it)
        }
    }

}
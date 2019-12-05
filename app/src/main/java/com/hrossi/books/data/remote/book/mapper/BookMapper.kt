package com.hrossi.books.data.remote.book.mapper

import com.hrossi.books.data.remote.book.dto.Book
import com.hrossi.books.data.remote.book.dto.BookDTO

class BookMapper {

    fun fromDTO(dto: BookDTO): Book {
        return Book(dto.title, dto.imageURL, dto.imageURL)
    }

}
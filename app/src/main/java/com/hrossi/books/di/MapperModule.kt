package com.hrossi.books.di

import com.hrossi.books.data.remote.book.mapper.BookMapper
import org.koin.dsl.module

var mapperModule = module {

    factory { BookMapper() }

}
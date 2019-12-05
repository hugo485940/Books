package com.hrossi.books.di

import com.hrossi.books.data.remote.book.BooksRepository
import com.hrossi.books.data.remote.book.BooksRepositoryImpl
import org.koin.dsl.module

var repositoryModule = module {

    factory<BooksRepository> { BooksRepositoryImpl(get(), get()) }

}
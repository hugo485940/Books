package com.hrossi.books.di

import com.hrossi.books.data.remote.BooksService
import org.koin.dsl.module
import retrofit2.Retrofit

var serviceModule = module {

    single { providesBookService(get()) }

}

fun providesBookService(retrofit: Retrofit): BooksService {
    return retrofit.create(BooksService::class.java)
}
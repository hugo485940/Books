package com.hrossi.books.di

import com.hrossi.books.presentation.books.BooksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {

    viewModel { BooksViewModel(get()) }

}
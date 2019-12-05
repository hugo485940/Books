package com.hrossi.books

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hrossi.books.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BooksApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BooksApplication)
            modules(listOf(networkModule, serviceModule, repositoryModule, mapperModule, viewModelModule))
        }
    }

}

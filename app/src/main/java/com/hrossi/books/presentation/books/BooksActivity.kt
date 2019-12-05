package com.hrossi.books.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hrossi.books.R

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.books_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BooksFragment.newInstance())
                .commitNow()
        }
    }

}

package com.hrossi.books.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hrossi.books.data.remote.book.BooksRepository
import com.hrossi.books.data.remote.book.dto.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.lang.Exception

class BooksViewModel(private val repo: BooksRepository) : ViewModel() {

    var loading = MutableLiveData<Boolean>()

    var books = MutableLiveData<List<Book>>()

    var networkError = MutableLiveData<Boolean>()

    var genericError = MutableLiveData<Boolean>()

    fun start() {
        requestBooks()
    }

    fun tryAgain() {
        requestBooks()
    }

    private fun requestBooks() {
        loading.postValue(true)

        CoroutineScope(Dispatchers.IO).launch {

            var result = emptyList<Book>()

            try {
                result = repo.getBooks()
            }
            catch (io : IOException){
                networkError.postValue(true)
            }
            catch (e : Exception){
                genericError.postValue(true)
            }

            withContext(Dispatchers.Main) {
                books.postValue(result)
                loading.postValue(false)
            }
        }
    }

}

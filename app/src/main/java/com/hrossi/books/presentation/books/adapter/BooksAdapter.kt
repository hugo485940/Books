package com.hrossi.books.presentation.books.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrossi.books.R
import com.hrossi.books.data.remote.book.dto.Book

class BooksAdapter(val books: List<Book>) : RecyclerView.Adapter<BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_book, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val obj = books[position]
        holder.format(obj)
    }

    override fun getItemCount(): Int {
        return books.size
    }

}
package com.hrossi.books.presentation.books.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hrossi.books.R
import com.hrossi.books.data.remote.book.dto.Book
import kotlinx.android.synthetic.main.list_item_book.view.*

class BooksViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun format(book: Book) {

        view.textViewTitle.text = book.title
        view.textViewAuthor.text = book.author

        Glide.with(view.imageViewBook)
            .load(book.imageURL)
            .placeholder(R.drawable.shape_placeholder)
            .into(view.imageViewBook)
        
        // TODO - ADD PLACEHOLDER

    }

}
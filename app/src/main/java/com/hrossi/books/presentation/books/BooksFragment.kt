package com.hrossi.books.presentation.books

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrossi.books.R
import com.hrossi.books.presentation.books.adapter.BooksAdapter
import kotlinx.android.synthetic.main.books_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BooksFragment : Fragment() {

    private val booksViewModel: BooksViewModel by viewModel()

    companion object {
        fun newInstance() = BooksFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.books_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        booksViewModel.start()
        setupObservables()
    }

    private fun setupObservables() {
        booksViewModel.loading.observe(this, Observer {
            if (it) {
                loadingProgressBar.visibility = View.VISIBLE
            } else {
                loadingProgressBar.visibility = View.INVISIBLE
            }
        })

        booksViewModel.books.observe(this, Observer {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = BooksAdapter(it)
        })

        booksViewModel.networkError.observe(this, Observer {
            if (it) {
                AlertDialog.Builder(context)
                    .setTitle(R.string.oopss)
                    .setMessage(R.string.network_error_message)
                    .setNegativeButton(R.string.cancel) { _: DialogInterface, _: Int -> activity?.finish() }
                    .setPositiveButton(R.string.retry) { _: DialogInterface, _: Int -> booksViewModel.tryAgain() }
                    .show()
            }
        })

        booksViewModel.genericError.observe(this, Observer {
            if (it) {
                AlertDialog.Builder(context)
                    .setTitle(R.string.oopss)
                    .setMessage(R.string.generic_error_message)
                    .setNegativeButton(R.string.cancel) { _: DialogInterface, _: Int -> activity?.finish() }
                    .setPositiveButton(R.string.retry) { _: DialogInterface, _: Int -> booksViewModel.tryAgain() }
                    .show()
            }
        })
    }

}
